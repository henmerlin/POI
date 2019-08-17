package com.henmerlin.poi.api;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.henmerlin.poi.api.Position;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AssetPosition
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-08-17T15:52:46.412-03:00")

public class AssetPosition   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("ignition")
  private Boolean ignition = null;

  @JsonProperty("speed")
  private Double speed = null;

  @JsonProperty("datePosition")
  private BigDecimal datePosition = null;

  @JsonProperty("position")
  private Position position = null;

  public AssetPosition id(Long id) {
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

  public AssetPosition ignition(Boolean ignition) {
    this.ignition = ignition;
    return this;
  }

  /**
   * Get ignition
   * @return ignition
  **/
  @ApiModelProperty(value = "")


  public Boolean isIgnition() {
    return ignition;
  }

  public void setIgnition(Boolean ignition) {
    this.ignition = ignition;
  }

  public AssetPosition speed(Double speed) {
    this.speed = speed;
    return this;
  }

  /**
   * Get speed
   * @return speed
  **/
  @ApiModelProperty(value = "")


  public Double getSpeed() {
    return speed;
  }

  public void setSpeed(Double speed) {
    this.speed = speed;
  }

  public AssetPosition datePosition(BigDecimal datePosition) {
    this.datePosition = datePosition;
    return this;
  }

  /**
   * Get datePosition
   * @return datePosition
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getDatePosition() {
    return datePosition;
  }

  public void setDatePosition(BigDecimal datePosition) {
    this.datePosition = datePosition;
  }

  public AssetPosition position(Position position) {
    this.position = position;
    return this;
  }

  /**
   * Get position
   * @return position
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Position getPosition() {
    return position;
  }

  public void setPosition(Position position) {
    this.position = position;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AssetPosition assetPosition = (AssetPosition) o;
    return Objects.equals(this.id, assetPosition.id) &&
        Objects.equals(this.ignition, assetPosition.ignition) &&
        Objects.equals(this.speed, assetPosition.speed) &&
        Objects.equals(this.datePosition, assetPosition.datePosition) &&
        Objects.equals(this.position, assetPosition.position);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, ignition, speed, datePosition, position);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AssetPosition {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    ignition: ").append(toIndentedString(ignition)).append("\n");
    sb.append("    speed: ").append(toIndentedString(speed)).append("\n");
    sb.append("    datePosition: ").append(toIndentedString(datePosition)).append("\n");
    sb.append("    position: ").append(toIndentedString(position)).append("\n");
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

