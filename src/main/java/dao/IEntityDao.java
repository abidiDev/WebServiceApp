package dao;

import java.util.List;

import entities.Employee;
import io.swagger.models.Response;

public interface IEntityDao <E> {
	public List<E> get();
	public List<E> filter(String f);
	public List<E> add( E entity);
	public List<E> update(E entity);
	public List<E> delete(String identifiant);
	}