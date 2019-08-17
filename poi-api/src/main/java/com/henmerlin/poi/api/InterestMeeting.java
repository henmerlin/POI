package com.henmerlin.poi.api;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * InterestMeeting
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-08-17T10:24:59.622-03:00")

public class InterestMeeting   {
  @JsonProperty("assetId")
  private Long assetId = null;

  @JsonProperty("poiId")
  private Long poiId = null;

  @JsonProperty("meetingSeconds")
  private Long meetingSeconds = null;

  public InterestMeeting assetId(Long assetId) {
    this.assetId = assetId;
    return this;
  }

  /**
   * Get assetId
   * @return assetId
  **/
  @ApiModelProperty(value = "")


  public Long getAssetId() {
    return assetId;
  }

  public void setAssetId(Long assetId) {
    this.assetId = assetId;
  }

  public InterestMeeting poiId(Long poiId) {
    this.poiId = poiId;
    return this;
  }

  /**
   * Get poiId
   * @return poiId
  **/
  @ApiModelProperty(value = "")


  public Long getPoiId() {
    return poiId;
  }

  public void setPoiId(Long poiId) {
    this.poiId = poiId;
  }

  public InterestMeeting meetingSeconds(Long meetingSeconds) {
    this.meetingSeconds = meetingSeconds;
    return this;
  }

  /**
   * Get meetingSeconds
   * @return meetingSeconds
  **/
  @ApiModelProperty(value = "")


  public Long getMeetingSeconds() {
    return meetingSeconds;
  }

  public void setMeetingSeconds(Long meetingSeconds) {
    this.meetingSeconds = meetingSeconds;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InterestMeeting interestMeeting = (InterestMeeting) o;
    return Objects.equals(this.assetId, interestMeeting.assetId) &&
        Objects.equals(this.poiId, interestMeeting.poiId) &&
        Objects.equals(this.meetingSeconds, interestMeeting.meetingSeconds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(assetId, poiId, meetingSeconds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InterestMeeting {\n");
    
    sb.append("    assetId: ").append(toIndentedString(assetId)).append("\n");
    sb.append("    poiId: ").append(toIndentedString(poiId)).append("\n");
    sb.append("    meetingSeconds: ").append(toIndentedString(meetingSeconds)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

