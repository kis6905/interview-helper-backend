package com.develeaf.interviewer.common.utils;

@FunctionalInterface
public interface EntityToDtoConverter {
	<T, R> R convert(T entity);
}
