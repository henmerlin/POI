/**
 * Swagger POI
 * POI
 *
 * OpenAPI spec version: 1.0.0-SNAPSHOT
 * Contact: henmerlin@gmail.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */
import { AssetPosition } from './assetPosition';
import { Poi } from './poi';


export interface InterestMeeting { 
    poi?: Poi;
    meetingSeconds?: number;
    positions?: Array<AssetPosition>;
}
