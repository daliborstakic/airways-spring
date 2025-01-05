package com.daliborstakic.airways.util;

import java.io.IOException;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class PointDeserializer extends JsonDeserializer<Point> {
	private static final GeometryFactory geometryFactory = new GeometryFactory();

	@Override
	public Point deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
		JsonNode node = p.getCodec().readTree(p);
		double latitude = node.get("latitude").asDouble();
		double longitude = node.get("longitude").asDouble();
		return geometryFactory.createPoint(new Coordinate(longitude, latitude));
	}
}
