package com.henmerlin.poi.api;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.henmerlin.poi.api.AssetPosition;
import com.henmerlin.poi.api.InterestMeeting;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Asset
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-08-19T07:09:36.022-03:00")

public class Asset   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("key")
  private String key = null;

  @JsonProperty("lastPositions")
  @Valid
  private List<AssetPosition> lastPositions = null;

  @JsonProperty("meetings")
  @Valid
  private List<InterestMeeting> meetings = null;

  public Asset id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Asset key(String key) {
    this.key = key;
    return this;
  }

  /**
   * Get key
   * @return key
  **/
  @ApiModelProperty(value = "")


  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public Asset lastPositions(List<AssetPosition> lastPositions) {
    this.lastPositions = lastPositions;
    return this;
  }

  public Asset addLastPositionsItem(AssetPosition lastPositionsItem) {
    if (this.lastPositions == null) {
      this.lastPositions = new ArrayList<AssetPosition>();
    }
    this.lastPositions.add(lastPositionsItem);
    return this;
  }

  /**
   * Get lastPositions
   * @return lastPositions
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<AssetPosition> getLastPositions() {
    return lastPositions;
  }

  public void setLastPositions(List<AssetPosition> lastPositions) {
    this.lastPositions = lastPositions;
  }

  public Asset meetings(List<InterestMeeting> meetings) {
    this.meetings = meetings;
    return this;
  }

  public Asset addMeetingsItem(InterestMeeting meetingsItem) {
    if (this.meetings == null) {
      this.meetings = new ArrayList<InterestMeeting>();
    }
    this.meetings.add(meetingsItem);
    return this;
  }

  /**
   * Get meetings
   * @return meetings
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<InterestMeeting> getMeetings() {
    return meetings;
  }

  public void setMeetings(List<InterestMeeting> meetings) {
    this.meetings = meetings;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Asset asset = (Asset) o;
    return Objects.equals(this.id, asset.id) &&
        Objects.equals(this.key, asset.key) &&
        Objects.equals(this.lastPositions, asset.lastPositions) &&
        Objects.equals(this.meetings, asset.meetings);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, key, lastPositions, meetings);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Asset {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
    sb.append("    lastPositions: ").append(toIndentedString(lastPositions)).append("\n");
    sb.append("    meetings: ").append(toIndentedString(meetings)).append("\n");
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

