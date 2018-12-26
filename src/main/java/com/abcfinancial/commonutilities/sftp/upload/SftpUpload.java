package com.abcfinancial.commonutilities.sftp.upload;

import com.jcraft.jsch.ChannelSftp;

public interface SftpUpload
{
    void uploadFile( ChannelSftp ChannelSftp,String sourceFile, String destinationFile );
}
