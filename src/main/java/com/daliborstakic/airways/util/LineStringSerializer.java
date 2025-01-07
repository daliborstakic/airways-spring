package com.daliborstakic.airways.util;

import java.io.IOException;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.LineString;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class LineStringSerializer extends JsonSerializer<LineString> {
	@Override
	public void serialize(LineString value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		gen.writeStartArray();

		for (Coordinate coord : value.getCoordinates()) {
			gen.writeStartArray();
			gen.writeNumber(coord.getX());
			gen.writeNumber(coord.getY());
			gen.writeEndArray();
		}

		gen.writeEndArray();
	}
}
