package com.weather.unzip;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Unzip {

	private Logger log = LoggerFactory.getLogger(Unzip.class);
	private final String FILE_NAME = "007034-99999-2012.op.gz";
	private final String urlString = "https://drive.google.com/open?id=0B0QtYwzM6bVAZGNzUEhjeU9XRjg&authuser=0";

	/**
	 * Downloads Unzips and gets out buffer reader
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public BufferedReader unzipAndReadFile() throws FileNotFoundException, IOException {
		BufferedReader bufferedReader = null;
		try {
			URL url = new URL(urlString);
			URLConnection connection = url.openConnection();
			InputStream inputStream = connection.getInputStream();
			bufferedReader = new BufferedReader(new InputStreamReader(new GZIPInputStream(inputStream)));
			return bufferedReader;
		} catch (ZipException e) {
			log.warn("File on URI not a GZip file : Unzipping the OP file in resources folder");
		}

		Resource resource = new ClassPathResource(FILE_NAME);
		bufferedReader = new BufferedReader(new InputStreamReader(new GZIPInputStream(resource.getInputStream())));
		return bufferedReader;

	}

}
