package com.daliborstakic.airways.util;

import java.io.IOException;

import org.locationtech.jts.geom.Point;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class PointSerializer extends JsonSerializer<Point> {
	@Override
	public void serialize(Point value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		if (value != null) {
			gen.writeStartObject();
			gen.writeNumberField("latitude", value.getY());
			gen.writeNumberField("longitude", value.getX());
			gen.writeEndObject();
		}
	}
}
