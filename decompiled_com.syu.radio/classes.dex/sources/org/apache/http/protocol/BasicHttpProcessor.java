package org.apache.http.protocol;

import java.io.IOException;
import java.util.List;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public final class BasicHttpProcessor implements HttpProcessor, HttpRequestInterceptorList, HttpResponseInterceptorList {
    protected List requestInterceptors;
    protected List responseInterceptors;

    public BasicHttpProcessor() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.protocol.HttpRequestInterceptorList
    public void addRequestInterceptor(HttpRequestInterceptor itcp) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.protocol.HttpRequestInterceptorList
    public void addRequestInterceptor(HttpRequestInterceptor itcp, int index) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.protocol.HttpResponseInterceptorList
    public void addResponseInterceptor(HttpResponseInterceptor itcp, int index) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.protocol.HttpRequestInterceptorList
    public void removeRequestInterceptorByClass(Class clazz) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.protocol.HttpResponseInterceptorList
    public void removeResponseInterceptorByClass(Class clazz) {
        throw new RuntimeException("Stub!");
    }

    public final void addInterceptor(HttpRequestInterceptor interceptor) {
        throw new RuntimeException("Stub!");
    }

    public final void addInterceptor(HttpRequestInterceptor interceptor, int index) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.protocol.HttpRequestInterceptorList
    public int getRequestInterceptorCount() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.protocol.HttpRequestInterceptorList
    public HttpRequestInterceptor getRequestInterceptor(int index) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.protocol.HttpRequestInterceptorList
    public void clearRequestInterceptors() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.protocol.HttpResponseInterceptorList
    public void addResponseInterceptor(HttpResponseInterceptor itcp) {
        throw new RuntimeException("Stub!");
    }

    public final void addInterceptor(HttpResponseInterceptor interceptor) {
        throw new RuntimeException("Stub!");
    }

    public final void addInterceptor(HttpResponseInterceptor interceptor, int index) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.protocol.HttpResponseInterceptorList
    public int getResponseInterceptorCount() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.protocol.HttpResponseInterceptorList
    public HttpResponseInterceptor getResponseInterceptor(int index) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.protocol.HttpResponseInterceptorList
    public void clearResponseInterceptors() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.protocol.HttpRequestInterceptorList, org.apache.http.protocol.HttpResponseInterceptorList
    public void setInterceptors(List list) {
        throw new RuntimeException("Stub!");
    }

    public void clearInterceptors() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpRequestInterceptor
    public void process(HttpRequest request, HttpContext context) throws HttpException, IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpResponseInterceptor
    public void process(HttpResponse response, HttpContext context) throws HttpException, IOException {
        throw new RuntimeException("Stub!");
    }

    protected void copyInterceptors(BasicHttpProcessor target) {
        throw new RuntimeException("Stub!");
    }

    public BasicHttpProcessor copy() {
        throw new RuntimeException("Stub!");
    }

    public Object clone() throws CloneNotSupportedException {
        throw new RuntimeException("Stub!");
    }
}
