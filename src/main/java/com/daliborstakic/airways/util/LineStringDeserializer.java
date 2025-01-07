package com.daliborstakic.airways.util;

import java.io.IOException;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class LineStringDeserializer extends JsonDeserializer<LineString> {

	private final GeometryFactory geometryFactory = new GeometryFactory();

	@Override
	public LineString deserialize(JsonParser parser, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		Coordinate[] coordinates = parser.readValueAs(Coordinate[].class);
		return geometryFactory.createLineString(coordinates);
	}
}
