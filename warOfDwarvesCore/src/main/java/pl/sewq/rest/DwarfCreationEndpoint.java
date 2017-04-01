package pl.sewq.rest;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import pl.sewq.core.dao.DwarfDao;
import pl.sewq.core.jpa.model.Dwarf;
import pl.sewq.core.jpa.model.Stats;
import pl.sewq.core.professions.DwarfClass;
import pl.sewq.core.security.CredencialsService;

@RequestScoped
@Path("/dwarfEndpoint")
public class DwarfCreationEndpoint {

	private static final String DWARF_NAME = "Bruenor";

	@EJB
	private DwarfDao dao;

	@GET
	@Path("/{pass}")
	@Consumes(MediaType.TEXT_PLAIN)
	public void greetings(@PathParam("pass") final String pass) {

		final String password = CredencialsService.hashPassword(pass);

		final Dwarf dwarf = new Dwarf(DWARF_NAME, DwarfClass.WARRIOR,
		        new Stats(4, 5, 6), password);

		dao.create(dwarf);
	}
}
