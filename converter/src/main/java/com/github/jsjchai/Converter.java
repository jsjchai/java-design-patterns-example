package com.github.jsjchai;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Generic converter, thanks to Java8 features not only provides a way of generic bidirectional
 * conversion between coresponding types, but also a common way of converting a collection of
 * objects of the same type, reducing boilerplate code to the absolute minimum.
 *
 * @param <V> VO representation's type
 * @param <U> Domain representation's type
 */
public class Converter<V, U> {

    private final Function<V, U> fromVO;
    private final Function<U, V> fromEntity;

    /**
     * @param fromVO Function that converts given vo entity into the domain entity.
     * @param fromEntity Function that converts given domain entity into the vo entity.
     */
    public Converter(final Function<V, U> fromVO, final Function<U, V> fromEntity) {
        this.fromVO = fromVO;
        this.fromEntity = fromEntity;
    }

    /**
     * @param vo VO entity
     * @return The domain representation - the result of the converting function application on vo
     * entity.
     */
    public final U convertFromVO(final V vo) {
        return fromVO.apply(vo);
    }

    /**
     * @param entity domain entity
     * @return The VO representation - the result of the converting function application on domain
     * entity.
     */
    public final V convertFromEntity(final U entity) {
        return fromEntity.apply(entity);
    }

    /**
     * @param vos collection of VO entities
     * @return List of domain representation of provided entities retrieved by mapping each of them
     * with the conversion function
     */
    public final List<U> createFromVOs(final Collection<V> vos) {
        return vos.stream().map(this::convertFromVO).collect(Collectors.toList());
    }

    /**
     * @param entities collection of domain entities
     * @return List of domain representation of provided entities retrieved by mapping each of them
     * with the conversion function
     */
    public final List<V> createFromEntities(final Collection<U> entities) {
        return entities.stream().map(this::convertFromEntity).collect(Collectors.toList());
    }

}
