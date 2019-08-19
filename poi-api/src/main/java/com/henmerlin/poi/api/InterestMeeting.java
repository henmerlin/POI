package com.henmerlin.poi.api;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.henmerlin.poi.api.AssetPosition;
import com.henmerlin.poi.api.Poi;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * InterestMeeting
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-08-19T07:09:36.022-03:00")

public class InterestMeeting   {
  @JsonProperty("poi")
  private Poi poi = null;

  @JsonProperty("meetingSeconds")
  private Integer meetingSeconds = null;

  @JsonProperty("positions")
  @Valid
  private List<AssetPosition> positions = null;

  public InterestMeeting poi(Poi poi) {
    this.poi = poi;
    return this;
  }

  /**
   * Get poi
   * @return poi
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Poi getPoi() {
    return poi;
  }

  public void setPoi(Poi poi) {
    this.poi = poi;
  }

  public InterestMeeting meetingSeconds(Integer meetingSeconds) {
    this.meetingSeconds = meetingSeconds;
    return this;
  }

  /**
   * Get meetingSeconds
   * @return meetingSeconds
  **/
  @ApiModelProperty(value = "")


  public Integer getMeetingSeconds() {
    return meetingSeconds;
  }

  public void setMeetingSeconds(Integer meetingSeconds) {
    this.meetingSeconds = meetingSeconds;
  }

  public InterestMeeting positions(List<AssetPosition> positions) {
    this.positions = positions;
    return this;
  }

  public InterestMeeting addPositionsItem(AssetPosition positionsItem) {
    if (this.positions == null) {
      this.positions = new ArrayList<AssetPosition>();
    }
    this.positions.add(positionsItem);
    return this;
  }

  /**
   * Get positions
   * @return positions
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<AssetPosition> getPositions() {
    return positions;
  }

  public void setPositions(List<AssetPosition> positions) {
    this.positions = positions;
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
    return Objects.equals(this.poi, interestMeeting.poi) &&
        Objects.equals(this.meetingSeconds, interestMeeting.meetingSeconds) &&
        Objects.equals(this.positions, interestMeeting.positions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(poi, meetingSeconds, positions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InterestMeeting {\n");
    
    sb.append("    poi: ").append(toIndentedString(poi)).append("\n");
    sb.append("    meetingSeconds: ").append(toIndentedString(meetingSeconds)).append("\n");
    sb.append("    positions: ").append(toIndentedString(positions)).append("\n");
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

