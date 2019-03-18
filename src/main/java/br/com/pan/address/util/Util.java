package br.com.pan.address.util;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

public final class Util {

	public static <D, T> List<D> mapAllObjects(final Collection<T> objectList, Class<D> outClass, ModelMapper instanceMapper) {
		return objectList.stream().map(entity -> instanceMapper.map(entity, outClass)).collect(Collectors.toList());
	}
}
