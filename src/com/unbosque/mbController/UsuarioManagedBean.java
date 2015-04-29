package com.unbosque.mbController;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.springframework.dao.DataAccessException;






import com.unbosque.entidad.Usuario;
import com.unbosque.service.UsuarioService;

@ManagedBean(name = "usuarioMBController")
@ViewScoped
public class UsuarioManagedBean implements Serializable {



	/**
	 * 
	 */
	private static final long serialVersionUID = -833450576444506528L;

	// Spring Customer Service is injected...
	@ManagedProperty(value = "#{UsuarioService}")
	UsuarioService usuarioService;






	List<Usuario> usuarioList;

	private Integer id;
	private String apellidosNombres;
	private String correo;
	private String estado;
	private Timestamp fechaClave;
	private Timestamp fechaCreacion;
	private Integer idProyecto;
	private String login;
	private String password;
	private String tipoUsuario;
	private Date  fecha = new Date();
	private Email mail;
	private String proyecto;
	
	public void addUsuario() {
		try {
			FacesContext context = FacesContext.getCurrentInstance();

			
			FacesMessage message = null;
			
			Usuario usuario = new Usuario();
			CifrarClave ci = new CifrarClave();
			usuario.setApellidosNombres(getApellidosNombres());
			
			
			
			usuario.setCorreo(getCorreo());
			usuario.setEstado('A');  
     		usuario.setFechaClave(new Timestamp(fecha.getTime())); 
			usuario.setFechaCreacion(new Timestamp(fecha.getTime())); 
			usuario.setIdProyecto(1); 
			usuario.setLogin(getLogin());
			usuario.setTipoUsuario(getTipoUsuario().charAt(0));
			usuario.setProyecto(getProyecto());
			
			usuario.setPassword(ci.cifradoClave(getPassword()));
			
			if(verificarUsuario(getLogin())&&verificarPass(getPassword())){
//				
			    FacesContext.getCurrentInstance().addMessage("Mensaje", new FacesMessage("Exitoso"));
				enviaMail(getCorreo(),getLogin(),getPassword());
				getUsuarioService().addUsuario(usuario);
				reset();
				}
			
				

		} catch (DataAccessException e) {
			e.printStackTrace();
		}

	}
	
	public void enviaMail(String mail,String usuario,String contrasena){
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = null;
		
        String clave = "bosqueproyectocaries"; 
        Email e = new Email("proyectocaries@gmail.com",clave,mail,"Proyecto Caries","Usuario: "+usuario+"   Contrasena: "+contrasena);
        if (e.sendMail()){
            
            FacesMessage msg = new FacesMessage(".","El email se envio correctamente");
        }else{
           
            context.addMessage(null, new FacesMessage(".", "El email no se envio correctamente") );
        }
    }
	
	
	public String deleteUsuario(Usuario usuario) {
		try {
			usuario.setEstado('I');
			getUsuarioService().updateUsuario(usuario);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return null;

	}
	
    public void reset() {
    	
    	this.setApellidosNombres("");
    	this.setCorreo("");
    	this.setIdProyecto(0);
    	this.setLogin("");
    	this.setPassword("");
    	
    	      
    }
    public boolean verificarUsuario(String usuario){
		 FacesContext context = FacesContext.getCurrentInstance();
		
		usuarioList = new ArrayList<Usuario>();
		usuarioList.addAll(getUsuarioService().getUsuarios());
		boolean h=true;
		
		for (int i = 0; i < usuarioList.size(); i++) {
			
			
			String user= usuarioList.get(i).getLogin().trim();
			
			if (user.equals(usuario)) {
				
				System.out.println(user+"   "+usuario);
				h=false;
				
			}
						
		}if (h==false) {
			FacesMessage msg = new FacesMessage("El usuario ya existe");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
			
		}
		return h;
				
	}

	 public static boolean verificarPass(String pass){
	
		 FacesContext context = FacesContext.getCurrentInstance();
		 
		 boolean a = false,b=false,c=false;	 
	int tamaño= pass.length();
	char letra;
	
	if(tamaño>=8){
	for (int i = 0; i < tamaño; i++) {
		
		letra=pass.charAt(i);
		if(letra>=65&&letra<=90&&a==false){
			a=true;
		System.out.println(pass);
		}
		if(letra>=97&&letra<=122&&b==false){
		b = true;
	}
	if(letra>=48&&letra<=57&&c==false){
		c = true;
		
	}
	 }
	if (a&&b&&c) {
		context.addMessage(null, new FacesMessage("Contraseña",  "Valida: ") );
		a=true;
	}else{
		context.addMessage(null, new FacesMessage("Contraseña",  "Invalida: ") );
		a=false;
	}
	}
	return a;
	 }
	 
	 public void modificarUsuario(Usuario usuario){
	        try {
	        	RequestContext context = RequestContext.getCurrentInstance();
	            FacesMessage msgs= null;
	        	
	          //  proyectojurado.setDocenteId(getDocenteId());
	            usuario.setApellidosNombres(getApellidosNombres());
	            
	            usuario.setCorreo(getCorreo());
	           usuario.setIdProyecto(getIdProyecto());
	           usuario.setLogin(getLogin());
	           usuario.setPassword(getPassword());
	          
	            getUsuarioService().updateUsuario(usuario);
	            msgs = new FacesMessage(FacesMessage.SEVERITY_INFO, "Titulo",
	                    "Registro agregado exitosamente.");

	        } catch (DataAccessException e) {
	            e.printStackTrace();
	        }
	        
	    }



	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Titulo","Cancelar");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}


	public List<Usuario> getUsuariosList() {
		usuarioList = new ArrayList<Usuario>();
		usuarioList.addAll(getUsuarioService().getUsuarios());
		
		
		return usuarioList;
		
	}

	public void getLogin1() throws IOException {
		CifrarClave ci = new CifrarClave();
		 FacesContext context = FacesContext.getCurrentInstance();
		 System.out.println(login);

		usuarioList = new ArrayList<Usuario>();
		usuarioList.addAll(getUsuarioService().getUsuarios());
		for (int j = 0; j < usuarioList.size(); j++) {
			if(usuarioList.get(j).getLogin().trim().equals(login.trim())&&(usuarioList.get(j).getPassword().equals(ci.cifradoClave(password)))){
				System.out.println(usuarioList.get(j).getTipoUsuario());
				if(usuarioList.get(j).getTipoUsuario().equals('A')){
					context.getExternalContext().redirect("admin/HomeAdmin.xhtml");	
				}
				if(usuarioList.get(j).getTipoUsuario().equals('U')){
					 context.getExternalContext().redirect("Odontologo/HomeOdontologo.xhtml");	
				}
			}
		}
	    FacesContext.getCurrentInstance().addMessage("login error: ", new FacesMessage("Usuario O Contrasena Invalidos"));
	}


	 public void verifyUseLogin(ComponentSystemEvent event) throws IOException{
		 getLogin1();
		  if(login==null){
			  FacesContext context=FacesContext.getCurrentInstance();
			   context.getExternalContext().redirect("Login.xhtml");		  }
		 }
	 
	 
	 
	 
	 public void  logOut() throws IOException{
			 FacesContext context=FacesContext.getCurrentInstance();
			   context.getExternalContext().redirect("Login.xhtml");		 
			   }
		 

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}





	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}





	public List<Usuario> getUsuarioList() {
		return usuarioList;
	}

	


	public Integer getId() {
		return id;
	}





	public void setId(Integer id) {
		this.id = id;
	}





	public String getApellidosNombres() {
		return apellidosNombres;
	}





	public void setApellidosNombres(String apellidosNombres) {
		this.apellidosNombres = apellidosNombres;
	}



	public void setUsuarioList(List<Usuario> usuarioList) {
		this.usuarioList = usuarioList;
	}


	public String getCorreo() {
		return correo;
	}





	public void setCorreo(String correo) {
		this.correo = correo;
	}





	public String getEstado() {
		return estado;
	}





	public void setEstado(String estado) {
		this.estado = estado;
	}





	public Timestamp getFechaClave() {
		return fechaClave;
	}





	public void setFechaClave(Timestamp fechaClave) {
		this.fechaClave = fechaClave;
	}





	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}





	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}





	public Integer getIdProyecto() {
		return idProyecto;
	}





	public void setIdProyecto(Integer idProyecto) {
		this.idProyecto = idProyecto;
	}





	public String getLogin() {
		return login;
	}





	public void setLogin(String login) {
		this.login = login;
	}





	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getPassword() {
		return password;
	}





	public void setPassword(String password) {
		this.password = password;
	}





	public String getTipoUsuario() {
		return tipoUsuario;
	}





	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getProyecto() {
		return proyecto;
	}

	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}


	
}