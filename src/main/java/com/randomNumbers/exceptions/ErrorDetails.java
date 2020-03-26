package com.randomNumbers.exceptions;

import java.util.List;

public class ErrorDetails {

  private final long timestamp;

  private final int status;

  private final String path;

  private final String error;

  private final String message;

  private final List<String> causes;

  public ErrorDetails(long timestamp, int status, String path, String error, String message, List<String> causes) {
    this.timestamp = timestamp;
    this.status = status;
    this.path = path;
    this.error = error;
    this.message = message;
    this.causes = causes;
  }


  public long getTimestamp() {
    return timestamp;
  }

  public int getStatus() {
    return status;
  }

  public String getPath() {
    return path;
  }

  public String getError() {
    return error;
  }

  public String getMessage() {
    return message;
  }

  public List<String> getCauses() {
    return causes;
  }
}
