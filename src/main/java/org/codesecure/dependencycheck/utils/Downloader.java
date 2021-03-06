package org.codesecure.dependencycheck.utils;
/*
 * This file is part of DependencyCheck.
 *
 * DependencyCheck is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 *
 * DependencyCheck is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * DependencyCheck. If not, see http://www.gnu.org/licenses/.
 *
 * Copyright (c) 2012 Jeremy Long. All Rights Reserved.
 */

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;

/**
 * A utility to download files from the Internet.
 *
 * @author Jeremy Long (jeremy.long@gmail.com)
 */
public class Downloader {

    /**
     * Private constructor for utility class.
     */
    private Downloader() {
    }

    /**
     * Retrieves a file from a given URL and saves it to the outputPath.
     *
     * @param url the URL of the file to download.
     * @param outputPath the path to the save the file to.
     * @throws DownloadFailedException is thrown if there is an error
     * downloading the file.
     */
    public static void fetchFile(URL url, String outputPath) throws DownloadFailedException {
        fetchFile(url, outputPath, false);
    }

    /**
     * Retrieves a file from a given URL and saves it to the outputPath.
     *
     * @param url the URL of the file to download.
     * @param outputPath the path to the save the file to.
     * @param unzip true/false indicating that the file being retrieved is
     * gzipped and if true, should be uncompressed before writting to the file.
     * @throws DownloadFailedException is thrown if there is an error
     * downloading the file.
     */
    public static void fetchFile(URL url, String outputPath, boolean unzip) throws DownloadFailedException {
        File f = new File(outputPath);
        fetchFile(url, f, unzip);
    }

    /**
     * Retrieves a file from a given URL and saves it to the outputPath.
     *
     * @param url the URL of the file to download.
     * @param outputPath the path to the save the file to.
     * @throws DownloadFailedException is thrown if there is an error
     * downloading the file.
     */
    public static void fetchFile(URL url, File outputPath) throws DownloadFailedException {
        fetchFile(url, outputPath, false);
    }

    /**
     * Retrieves a file from a given URL and saves it to the outputPath.
     *
     * @param url the URL of the file to download.
     * @param outputPath the path to the save the file to.
     * @param unzip true/false indicating that the file being retrieved is
     * gzipped and if true, should be uncompressed before writting to the file.
     * @throws DownloadFailedException is thrown if there is an error
     * downloading the file.
     */
    public static void fetchFile(URL url, File outputPath, boolean unzip) throws DownloadFailedException {
        HttpURLConnection conn = null;
        Proxy proxy = null;
        String proxyUrl = Settings.getString(Settings.KEYS.PROXY_URL);

        try {
            if (proxyUrl != null) {
                int proxyPort = Settings.getInt(Settings.KEYS.PROXY_PORT);
                SocketAddress addr = new InetSocketAddress(proxyUrl, proxyPort);
                proxy = new Proxy(Proxy.Type.HTTP, addr);
                conn = (HttpURLConnection) url.openConnection(proxy);
            } else {
                conn = (HttpURLConnection) url.openConnection();
            }
            if (Settings.getString(Settings.KEYS.CONNECTION_TIMEOUT) != null) {
                int timeout = Settings.getInt(Settings.KEYS.CONNECTION_TIMEOUT);
                conn.setConnectTimeout(timeout);
            }
            conn.setRequestProperty("Accept-Encoding", "gzip, deflate");
            conn.connect();
        } catch (IOException ex) {
            try {
                if (conn != null) {
                    conn.disconnect();
                }
            } finally {
                conn = null;
            }
            throw new DownloadFailedException("Error downloading file.", ex);
        }
        String encoding = conn.getContentEncoding();

        BufferedOutputStream writer = null;
        try {
            InputStream reader;
            if (unzip || (encoding != null && "gzip".equalsIgnoreCase(encoding))) {
                reader = new GZIPInputStream(conn.getInputStream());
            } else if (encoding != null && "deflate".equalsIgnoreCase(encoding)) {
                reader = new InflaterInputStream(conn.getInputStream());
            } else {
                reader = conn.getInputStream();
            }

            writer = new BufferedOutputStream(new FileOutputStream(outputPath));
            byte[] buffer = new byte[4096];
            int bytesRead = 0;
            while ((bytesRead = reader.read(buffer)) > 0) {
                writer.write(buffer, 0, bytesRead);
            }
        } catch (Exception ex) {
            throw new DownloadFailedException("Error saving downloaded file.", ex);
        } finally {
            try {
                writer.close();
                writer = null;
            } catch (Exception ex) {
                Logger.getLogger(Downloader.class.getName()).log(Level.FINEST,
                        "Error closing the writter in Downloader.", ex);
            }
            try {
                conn.disconnect();
            } finally {
                conn = null;
            }
        }
    }
}
