package org.zkoss.jcef.application;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.zkoss.jcef.browser.MainFrame;

import me.friwi.jcefmaven.CefAppBuilder;
import me.friwi.jcefmaven.CefInitializationException;
import me.friwi.jcefmaven.UnsupportedPlatformException;
import me.friwi.jcefmaven.impl.progress.ConsoleProgressHandler;

@SpringBootApplication
public class ZkJcefApplication {
	public static void main(String[] args) throws IOException, UnsupportedPlatformException, InterruptedException, CefInitializationException, InvocationTargetException {
		SpringApplicationBuilder springBuilder = new SpringApplicationBuilder(ZkJcefApplication.class);
		springBuilder.headless(false);
		ConfigurableApplicationContext context = springBuilder.run(args);
        /* Run JCEF application in its own thread*/
		Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
				//Create a new CefAppBuilder instance
				CefAppBuilder cefBuilder = new CefAppBuilder();
				//Configure the builder instance
				cefBuilder.setInstallDir(new File("jcef-bundle")); //Default
				cefBuilder.setProgressHandler(new ConsoleProgressHandler()); //Default
				cefBuilder.getCefSettings().windowless_rendering_enabled = true; //Default - select OSR mode
		        // Windowed rendering mode is used by default. If you want to test OSR mode set |useOsr| to true and recompile.
		        boolean useOsr = false;
            	try {
					new MainFrame("http://localhost:8080", useOsr, false, args);
				} catch (UnsupportedPlatformException | CefInitializationException | IOException
						| InterruptedException e) {
					e.printStackTrace();
				}
            }
        });
        thread.start();
	}
}