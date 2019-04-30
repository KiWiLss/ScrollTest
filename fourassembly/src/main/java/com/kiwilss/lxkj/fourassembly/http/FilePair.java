package com.kiwilss.lxkj.fourassembly.http;

public  class FilePair{
        String mFileName;
        byte[] mBinaryData;
        public FilePair(String fileName, byte[] data) {
            this.mFileName = fileName;
            this.mBinaryData = data;
        }
    }

