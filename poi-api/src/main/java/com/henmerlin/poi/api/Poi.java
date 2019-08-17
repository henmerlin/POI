package com.henmerlin.poi.api;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Poi
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-08-17T01:30:19.128-03:00")

public class Poi   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("radiusMeters")
  private BigDecimal radiusMeters = null;

  @JsonProperty("lat")
  private BigDecimal lat = null;

  @JsonProperty("long")
  private BigDecimal _long = null;

  public Poi id(Long id) {
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

  public Poi name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Poi radiusMeters(BigDecimal radiusMeters) {
    this.radiusMeters = radiusMeters;
    return this;
  }

  /**
   * Get radiusMeters
   * @return radiusMeters
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public BigDecimal getRadiusMeters() {
    return radiusMeters;
  }

  public void setRadiusMeters(BigDecimal radiusMeters) {
    this.radiusMeters = radiusMeters;
  }

  public Poi lat(BigDecimal lat) {
    this.lat = lat;
    return this;
  }

  /**
   * Get lat
   * @return lat
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public BigDecimal getLat() {
    return lat;
  }

  public void setLat(BigDecimal lat) {
    this.lat = lat;
  }

  public Poi _long(BigDecimal _long) {
    this._long = _long;
    return this;
  }

  /**
   * Get _long
   * @return _long
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public BigDecimal getLong() {
    return _long;
  }

  public void setLong(BigDecimal _long) {
    this._long = _long;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Poi poi = (Poi) o;
    return Objects.equals(this.id, poi.id) &&
        Objects.equals(this.name, poi.name) &&
        Objects.equals(this.radiusMeters, poi.radiusMeters) &&
        Objects.equals(this.lat, poi.lat) &&
        Objects.equals(this._long, poi._long);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, radiusMeters, lat, _long);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Poi {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    radiusMeters: ").append(toIndentedString(radiusMeters)).append("\n");
    sb.append("    lat: ").append(toIndentedString(lat)).append("\n");
    sb.append("    _long: ").append(toIndentedString(_long)).append("\n");
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

