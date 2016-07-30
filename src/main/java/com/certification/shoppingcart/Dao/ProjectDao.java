package com.certification.shoppingcart.Dao;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import com.certification.shoppingcart.model.Project;

public class ProjectDao {

	private static Map<Long, Project> banco = new HashMap<Long, Project>();
    private static AtomicLong contador = new AtomicLong(1);

    static {
        banco.put(1l, new Project(1l, "Minha loja", 2014));
        banco.put(2l, new Project(2l, "Teste", 2012));
    }

    public void adiciona(Project Project) {
        long id = contador.incrementAndGet();
        Project.setId(id);
        banco.put(id, Project);
    }

    public Project busca(Long id) {
        return banco.get(id);
    }

    public Project remove(long id) {
        return banco.remove(id);
    }

}
