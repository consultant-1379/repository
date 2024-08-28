/**
 * 
 */
package com.ericsson.eniq.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.apache.commons.logging.Log;


/**
 * @author eheijun
 *
 */
public final class CommandRunner {
  
  /**
   * This command is support for executing any system commands from GUI. Use getExitValue() to get the exitValue of the
   * system command.
   * 
   * @param cmd
   *          the command that is needed to run
   * @return returns the output of the completed command
   * @throws IOException
   */
	private CommandRunner(){
		
	}
  public static final String runCmd(final String cmd, final Log log) throws IOException {
    final StringBuilder result = new StringBuilder();

    //
    // We run something from the underlying OS - very non portable,
    // but there is no other way (me thinks)
    // create runtime environment and run the process
    final Process process = Runtime.getRuntime().exec(cmd); //NOSONAR

    // read what process wrote to the STDIN (immediate)
    final BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8));
    String line;
    while ((line = in.readLine()) != null) {
      result.append(line);
    }

    // wait for process to end
    try {
      process.waitFor();
    } catch (final InterruptedException e) {
      try {
        process.waitFor();
      } catch (final InterruptedException ie) {
        log.warn(ie);
        Thread.currentThread().interrupt();

      }
    }

    // and read whatever was left to STDIN
    while ((line = in.readLine()) != null) {
      result.append(line);
    }

    // cleanup
    in.close();
    process.getErrorStream().close();
    process.getOutputStream().close();

    // save exit information of the process and return with output string
    return result.toString();
  }

  

}
