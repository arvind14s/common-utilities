package com.abcfinancial.commonutilities;

import com.abcfinancial.commonutilities.sftp.config.SftpConfigClient;
import com.abcfinancial.commonutilities.sftp.upload.SftpUploadService;
import com.jcraft.jsch.ChannelSftp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommonUtilitiesApplicationTests {

    private static ResourceBundle fileResourceBundle = ResourceBundle.getBundle( "file" );
    String host = fileResourceBundle.getString( "sftp.host" );
    String userName = fileResourceBundle.getString( "sftp.user" );
    String password = fileResourceBundle.getString( "sftp.password" );
    String remoteDirectory = fileResourceBundle.getString( "sftp.remote.directory.download" );
    String localDirectory = fileResourceBundle.getString( "sftp.local.directory.download" );
	@Test
	public void contextLoads() {
        SftpConfigClient sftpConfigClient=new SftpConfigClient();
        ChannelSftp channelSftp= sftpConfigClient.connect(host,22,userName,password);
        SftpUploadService sftpUploadService=new SftpUploadService();
        sftpUploadService.uploadFile( channelSftp,remoteDirectory,localDirectory );

        sftpConfigClient.disconnect( channelSftp );

	}

}

