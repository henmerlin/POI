package com.henmerlin.poi.api;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-08-17T01:30:19.128-03:00")

public class Asset   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("key")
  private String key = null;

  @JsonProperty("meeetings")
  @Valid
  private List<InterestMeeting> meeetings = null;

  public Asset id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
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

  public Asset meeetings(List<InterestMeeting> meeetings) {
    this.meeetings = meeetings;
    return this;
  }

  public Asset addMeeetingsItem(InterestMeeting meeetingsItem) {
    if (this.meeetings == null) {
      this.meeetings = new ArrayList<InterestMeeting>();
    }
    this.meeetings.add(meeetingsItem);
    return this;
  }

  /**
   * Get meeetings
   * @return meeetings
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<InterestMeeting> getMeeetings() {
    return meeetings;
  }

  public void setMeeetings(List<InterestMeeting> meeetings) {
    this.meeetings = meeetings;
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
        Objects.equals(this.meeetings, asset.meeetings);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, key, meeetings);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Asset {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
    sb.append("    meeetings: ").append(toIndentedString(meeetings)).append("\n");
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

