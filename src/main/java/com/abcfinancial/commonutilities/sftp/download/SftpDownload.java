package com.abcfinancial.commonutilities.sftp.download;

import com.jcraft.jsch.ChannelSftp;

public interface SftpDownload
{
    void downloadFile(ChannelSftp ChannelSftp, String sourceFile, String destinationFile );
}
