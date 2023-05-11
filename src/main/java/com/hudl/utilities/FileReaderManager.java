package com.hudl.utilities;

public class FileReaderManager {

    private static FileReaderManager fileReaderManager = new FileReaderManager();
    private static SecretFileReader secretFileReader;

    private FileReaderManager() {
    }

    public static FileReaderManager getInstance( ) {
        return fileReaderManager;
    }

    public SecretFileReader getConfigReader() {
        return (secretFileReader == null) ? new SecretFileReader() : secretFileReader;
    }
}
