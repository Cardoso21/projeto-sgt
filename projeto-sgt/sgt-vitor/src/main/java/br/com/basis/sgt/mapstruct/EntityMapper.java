package br.com.basis.sgt.mapstruct;

public interface EntityMapper <D, E> {

	D ToEntity(E dto);
	E ToDto(D entity);

}
