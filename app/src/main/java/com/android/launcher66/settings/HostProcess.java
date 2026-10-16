package com.android.launcher66.settings;

import android.os.Binder;
import android.os.ParcelFileDescriptor;

import com.syu.util.WindowHostVdClient;
import com.syu.vdhost.VdHostProtocol;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * A command the VD host runs for the launcher (see VdHostProtocol.Proxy.exec()), as a Process:
 * its output comes through a pipe, and it ends when the host says so. Lets LogcatWorker read the
 * whole log without system privileges, as the host may (root or Shizuku).
 */
final class HostProcess extends Process {
    private final InputStream mOutput;
    private final VdHostProtocol.ExecHandle mHandle;
    /** Lets the host stop the command if this process dies. */
    private final Binder mToken;
    private final CountDownLatch mExited = new CountDownLatch(1);
    private volatile int mExitCode = -1;
    private boolean mWaiterStarted;

    private HostProcess(ParcelFileDescriptor readEnd, VdHostProtocol.ExecHandle handle, Binder token) {
        mOutput = new ParcelFileDescriptor.AutoCloseInputStream(readEnd);
        mHandle = handle;
        mToken = token;
    }

    /** Whether there is a host to run commands now. */
    static boolean isAvailable() {
        return WindowHostVdClient.hasPrivilegedHost();
    }

    /** @throws IOException when there is no host, or it refused the command */
    static Process start(String... command) throws IOException {
        ParcelFileDescriptor[] pipe = ParcelFileDescriptor.createPipe();
        Binder token = new Binder();
        try {
            VdHostProtocol.ExecHandle handle = WindowHostVdClient.exec(command, pipe[1], token);
            if (handle == null) {
                throw new IOException("no VD host to run " + command[0]);
            }
            return new HostProcess(pipe[0], handle, token);
        } catch (IOException e) {
            pipe[0].close();
            throw e;
        } catch (Throwable t) {
            pipe[0].close();
            throw new IOException("the VD host did not run " + command[0] + ": " + t, t);
        } finally {
            // The host has its own copy; without closing ours the output would never end.
            pipe[1].close();
        }
    }

    @Override
    public OutputStream getOutputStream() {
        return new OutputStream() {
            @Override
            public void write(int b) {
                // The command reads no input.
            }
        };
    }

    @Override
    public InputStream getInputStream() {
        return mOutput;
    }

    /** Merged into the output by the host. */
    @Override
    public InputStream getErrorStream() {
        return new ByteArrayInputStream(new byte[0]);
    }

    @Override
    public int waitFor() throws InterruptedException {
        startWaiter();
        mExited.await();
        return mExitCode;
    }

    @Override
    public boolean waitFor(long timeout, TimeUnit unit) throws InterruptedException {
        startWaiter();
        return mExited.await(timeout, unit);
    }

    @Override
    public int exitValue() {
        if (mExited.getCount() > 0) throw new IllegalThreadStateException("still running");
        return mExitCode;
    }

    @Override
    public boolean isAlive() {
        return mExited.getCount() > 0;
    }

    @Override
    public void destroy() {
        try {
            mHandle.destroy();
        } catch (Throwable ignore) {
            // The host is gone, and the command with it.
        }
        try {
            mOutput.close();
        } catch (IOException ignore) {
        }
    }

    /** The host's waitFor() blocks, so it waits on a thread of its own. */
    private synchronized void startWaiter() {
        if (mWaiterStarted) return;
        mWaiterStarted = true;
        Thread t = new Thread(() -> {
            try {
                mExitCode = mHandle.waitFor();
            } catch (Throwable ignore) {
                mExitCode = -1;     // the host died, and the command with it
            } finally {
                mExited.countDown();
            }
        }, "HostProcessWait");
        t.setDaemon(true);
        t.start();
    }
}
