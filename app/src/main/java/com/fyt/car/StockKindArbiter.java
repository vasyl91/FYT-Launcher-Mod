package com.fyt.car;

/**
 * Which of FYT's stock sources the music widget shows, from the MCU's sound channel and from the
 * players themselves. No Android classes in here, so the channel sequences of both units are unit
 * tested on the JVM. Main thread only, like everything that feeds it.
 *
 * The channels (CarStates.mAppID, RemoteTools.sendInt(0, 0, x)) and what they show:
 * <pre>
 *   channel   7862 / 8581 (com.syu.music)        7870 (com.syu.media)
 *   8         SYU_MUSIC                          MEDIA_MUSIC
 *   7         -                                  MEDIA_ONLINE
 *   3         SYU_MUSIC (BT is out of scope)     MEDIA_BT
 *   1         RADIO                              RADIO
 *   0, 10, .. no change: the widget shows the last source, paused
 * </pre>
 */
public final class StockKindArbiter {

    public static final int CH_RADIO = 1;
    public static final int CH_BT = 3;
    public static final int CH_ONLINE = 7;
    public static final int CH_MUSIC = 8;

    public enum Kind {
        /** com.syu.music: its intents; MusicService.onStartCommand() fills the fields. */
        SYU_MUSIC(CH_MUSIC, false),
        /** com.syu.media, local / USB music: IPlayer of its MusicService. */
        MEDIA_MUSIC(CH_MUSIC, false),
        /** com.syu.media, internet radio: IPlayer of its OnlineRadioService. */
        MEDIA_ONLINE(CH_ONLINE, false),
        /** BT audio, read from com.syu.ms module 2 (7870; the overlay keeps its own state). */
        MEDIA_BT(CH_BT, true),
        /** FM / AM, read from com.syu.ms module 1 (the overlay keeps its own state). */
        RADIO(CH_RADIO, true);

        /** The MCU channel this source plays on. */
        public final int channel;
        /**
         * Read from com.syu.ms and kept apart from MusicService's fields: com.syu.music sends one
         * more update, with state=false, after it loses the channel, and that would overwrite the
         * station.
         */
        public final boolean overlay;

        Kind(int channel, boolean overlay) {
            this.channel = channel;
            this.overlay = overlay;
        }

        public boolean isMediaPlayer() {
            return this == MEDIA_MUSIC || this == MEDIA_ONLINE;
        }
    }

    private boolean syuMediaUnit;
    private int lastChannel;
    /** The last channel that stood for a source; the one {@link #shown} follows. */
    private int lastKindChannel = -1;
    private Kind shown;

    public StockKindArbiter(boolean syuMediaUnit, int currentChannel) {
        this.syuMediaUnit = syuMediaUnit;
        this.lastChannel = currentChannel;
        this.shown = initial();
    }

    /** The source a channel stands for on this unit; null for a channel that is none (0, 10, calls). */
    public Kind kindForChannel(int channel) {
        switch (channel) {
            case CH_MUSIC:
                return syuMediaUnit ? Kind.MEDIA_MUSIC : Kind.SYU_MUSIC;
            case CH_RADIO:
                return Kind.RADIO;
            case CH_BT:
                return syuMediaUnit ? Kind.MEDIA_BT : Kind.SYU_MUSIC;
            case CH_ONLINE:
                return syuMediaUnit ? Kind.MEDIA_ONLINE : null;
            default:
                return null;
        }
    }

    /**
     * The channel changed.
     *
     * @return whether the source shown is another one now
     */
    public boolean onChannel(int channel) {
        lastChannel = channel;
        Kind kind = kindForChannel(channel);
        if (kind == null) {
            return false;
        }
        lastKindChannel = channel;
        return moveTo(kind);
    }

    /**
     * A com.syu.media player reported that it plays: it takes over at once, without waiting for
     * the channel (the MCU follows a moment later). Not from the radio or BT while the MCU is
     * still on their channel: what is heard is theirs, and the player's report is one read before
     * its own pause, which nothing would undo (an overlay never reports "playing" to take the
     * widget back).
     *
     * @return whether the source shown is another one now
     */
    public boolean onPlayerPlaying(Kind kind) {
        if (!syuMediaUnit || kind == null || !kind.isMediaPlayer()) {
            return false;
        }
        if (shown.overlay && lastChannel == shown.channel) {
            return false;
        }
        lastKindChannel = kind.channel;
        return moveTo(kind);
    }

    /**
     * Whether this is a 7870 is known a little after the start (a package lookup off the main
     * thread); the source shown is worked out again from the channels seen until then.
     *
     * @return whether the source shown is another one now
     */
    public boolean setSyuMediaUnit(boolean unit) {
        if (syuMediaUnit == unit) {
            return false;
        }
        syuMediaUnit = unit;
        Kind kind = lastKindChannel != -1 ? kindForChannel(lastKindChannel) : initial();
        return moveTo(kind != null ? kind : initial());
    }

    public Kind shown() {
        return shown;
    }

    /** The shown source when it is an MCU overlay (radio, on the 7870 BT too), else null. */
    public Kind overlayShown() {
        return shown.overlay ? shown : null;
    }

    public boolean isSyuMediaUnit() {
        return syuMediaUnit;
    }

    public int lastChannel() {
        return lastChannel;
    }

    private boolean moveTo(Kind kind) {
        if (kind == shown) {
            return false;
        }
        shown = kind;
        return true;
    }

    /** Before any channel was seen: the player of the unit, or the source of the current channel. */
    private Kind initial() {
        Kind fromChannel = kindForChannel(lastChannel);
        if (fromChannel != null) {
            return fromChannel;
        }
        return syuMediaUnit ? Kind.MEDIA_MUSIC : Kind.SYU_MUSIC;
    }
}
