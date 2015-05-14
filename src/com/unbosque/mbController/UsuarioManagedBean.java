package com.unbosque.mbController;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.persistence.Column;
import javax.persistence.Id;

import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.springframework.dao.DataAccessException;














import com.unbosque.entidad.Auditoria;
import com.unbosque.entidad.Departamento;
import com.unbosque.entidad.Usuario;
import com.unbosque.service.UsuarioService;
import com.unbosque.service.AuditoriaService;

@ManagedBean(name = "usuarioMBController")
@SessionScoped 
public class UsuarioManagedBean implements Serializable {



	/**
	 * 
	 */
	private static final long serialVersionUID = -833450576444506528L;

	// Spring Customer Service is injected...
	@ManagedProperty(value = "#{UsuarioService}")
	
	UsuarioService usuarioService;
	
	@ManagedProperty(value = "#{AuditoriaService}")

	AuditoriaService auditoriaService;
	final static Logger logger = Logger.getLogger(UsuarioManagedBean.class);


	

	ArrayList<String> use= new ArrayList<String>();

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
	private int block;
	private String newPass;
	private String user;
	
	
	
	//atributos auditoria
	private String descripcion;

	
	private Time fechaAuditoria;

	private String operacion;

	
	private String tablaAuditoria;

	private String usuarioId;
	
	String usuG;
	
	public void addUsuario() {
		try {
			FacesContext context = FacesContext.getCurrentInstance();

			
			FacesMessage message = null;
			
			Usuario usuario = new Usuario();
			CifrarClave ci = new CifrarClave();
			usuario.setApellidosNombres(getApellidosNombres());
			
			long treinta = -(30 * 24 * 60 * 60 * 1000) +System.currentTimeMillis();
			
			 SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
			    Date now = new Date();
			    String strDate = sdfDate.format(now);
			    System.out.println(strDate);
			    
			usuario.setCorreo(getCorreo());
			usuario.setEstado('A');  
     		usuario.setFechaClave(new Timestamp(treinta)); 
     		usuario.setFechaCreacion(new Timestamp(System.currentTimeMillis())); 
			usuario.setProyecto(getProyecto());
			usuario.setLogin(getLogin());
			usuario.setTipoUsuario(getTipoUsuario().charAt(0));
			usuario.setProyecto(getProyecto());
			
			usuario.setPassword(ci.cifradoClave(getPassword()));
			
			if(verificarUsuario(getLogin())&&verificarPass(getPassword())){
//				
			    FacesContext.getCurrentInstance().addMessage("Mensaje", new FacesMessage("Exitoso"));
				enviaMail(getCorreo(),getLogin(),getPassword());
				getUsuarioService().addUsuario(usuario);
				System.out.println("sd");
				logger.info("Se ha registrado un nuevo Usuario");
				Auditoria audi = new Auditoria();
				audi.setUsuarioId(usuG);
				audi.setOperacion("A");
				audi.setDescripcion("Se a creado un usuario:  "+getLogin());
				audi.setFechaAuditoria(new Time(System.currentTimeMillis()));
				audi.setTablaAuditoria("tabla agregar usuario");
				getAuditoriaService().addAuditoria(audi);
				reset();
				}
			
				

		} catch (DataAccessException e) {
			e.printStackTrace();
		}

	}
	
	 
	public List<String> getUsuarioNombre() {
        usuarioList = new ArrayList<Usuario>();
        List<String> usu = new ArrayList<String>();
        usuarioList.addAll(getUsuarioService().getUsuarios());
        for (int i = 0; i < usuarioList.size(); i++) {
        	usu.add(usuarioList.get(i).getProyecto());
		}
        usu = new ArrayList<String>(new LinkedHashSet<String>(usu));

        return usu;
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
			Auditoria audi = new Auditoria();
			audi.setUsuarioId(usuG);
			audi.setOperacion("D");
			audi.setDescripcion("Se a eliminado el usuario: "+usuario.getLogin());
			audi.setFechaAuditoria(new Time(System.currentTimeMillis()));
			audi.setTablaAuditoria("eliminar usuario");
			getAuditoriaService().addAuditoria(audi);
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
    
    public void cambioContra() throws IOException{
    	CifrarClave cfr=new CifrarClave();
    	
    	 FacesContext context = FacesContext.getCurrentInstance();
    	 try {
    	    	Usuario user = getUsuarioService().getUsuarioByLogin(getLogin());

		
    System.out.println(user.getLogin());
    	if (user.getPassword().equals(cfr.cifradoClave(getPassword()))) {
    		
    		 user.setPassword(cfr.cifradoClave(getNewPass()));
	           
	         if (verificarPass(getNewPass())) {
	        	 long treinta = -(30 * 24 * 60 * 60 * 1000) +fecha.getTime();
	        	 user.setFechaClave(new Timestamp(treinta));
	        	 getUsuarioService().updateUsuario(user);
			    	FacesContext.getCurrentInstance().addMessage("login error: ", new FacesMessage("Exitoso"));
			    	Auditoria audi = new Auditoria();
					audi.setUsuarioId(getLogin());
					audi.setOperacion("C");
					audi.setDescripcion("Se a cambiado la contraseña del usuario:  "+ getLogin());
					audi.setFechaAuditoria(new Time(System.currentTimeMillis()));
					audi.setTablaAuditoria("tabla cambiar contraseña ");
					getAuditoriaService().addAuditoria(audi);
			    	
		    		context.getExternalContext().redirect("../Login.xhtml");	

			    				
			}
	               		
    	}
    	 } catch (Exception e) {
    		 FacesContext.getCurrentInstance().addMessage("Mensaje", new FacesMessage("El usuario no existe"));
 		}
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
	            
	          
	        		usuario.setApellidosNombres(getApellidosNombres());

	          
	CifrarClave ci = new CifrarClave();
	
	
   
  usuario.setEstado(getEstado().charAt(0));
   
    getUsuarioService().updateUsuario(usuario);
    
    Auditoria audi = new Auditoria();
	audi.setUsuarioId(usuG);
	audi.setOperacion("M");
	audi.setDescripcion("Se a modificado el usuario   "+usuario.getLogin());
	audi.setFechaAuditoria(new Time(System.currentTimeMillis()));
	audi.setTablaAuditoria("tabla Modificar usuario");
	getAuditoriaService().addAuditoria(audi);
	
    msgs = new FacesMessage(FacesMessage.SEVERITY_INFO, "Titulo",
            "Registro agregado exitosamente.");
	
				
	          //  proyectojurado.setDocenteId(getDocenteId());
	            
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

	public void propUsuario(){
		 Usuario usuario = getUsuarioService().getUsuarioByLogin(getLogin());

		
		user=usuario.getProyecto();
		System.out.println("asdasdasdasdasdasdadasda");
System.out.println(user);		
	}
	public void getLogin1() throws IOException {
		propUsuario();
		use.add(getLogin());
		CifrarClave ci = new CifrarClave();
		 FacesContext context = FacesContext.getCurrentInstance();
		 Usuario usuario = getUsuarioService().getUsuarioByLogin(getLogin());
		 
		 long actual =fecha.getTime();
		                                      

		
		
		 int j;
		usuarioList = new ArrayList<Usuario>();
		usuarioList.addAll(getUsuarioService().getUsuarios());
		for (j = 0; j < usuarioList.size(); j++) {
			if(usuarioList.get(j).getLogin().trim().equals(login.trim())&&(usuarioList.get(j).getPassword().equals(ci.cifradoClave(password)))){
				System.out.println(usuarioList.get(j).getTipoUsuario());
				
				if(usuarioList.get(j).getTipoUsuario().equals('A')&&usuarioList.get(j).getEstado()==('A')){
					if(actual>usuario.getFechaClave().getTime()){
					    FacesContext.getCurrentInstance().addMessage("login error: ", new FacesMessage("Debe Cambiar su clave: "+ ""));
						 context.getExternalContext().redirect("admin/cambioContra.xhtml");	}
						 else{
							 usuG=usuario.getLogin();
							 context.getExternalContext().redirect("admin/HomeAdmin.xhtml");	
								block=0;
								logger.info("Se ha registrado un nuevo Usuario");
						 }
					
				}
				if(usuarioList.get(j).getTipoUsuario().equals('U')&&usuarioList.get(j).getEstado()==('A')){
					if(actual>usuario.getFechaClave().getTime()){
					    FacesContext.getCurrentInstance().addMessage("login error: ", new FacesMessage("Debe Cambiar su clave: "+ ""));
						 context.getExternalContext().redirect("admin/cambioContra.xhtml");	}
					else{
						
						context.getExternalContext().redirect("Odontologo/HomeOdontologo.xhtml");	
						 block=0;
					}
					 
				} 
			}
		}
		block++;
	    FacesContext.getCurrentInstance().addMessage("login error: ", new FacesMessage("Usuario O Contrasena Invalidos O usuario Inactivo"));
	  	    if(use.size()!=0){
		   
	   //System.out.println(usuario.getLogin());
	  	    	try {
	  	    		 if (block>=3&&usuario.getTipoUsuario().equals('U')&&usuario.getLogin().trim().equals(use.get(use.size()-2))) {
	  	   	    	deleteUsuario(usuario);
	  	   	    	block=0;
	  	   	    	FacesContext.getCurrentInstance().addMessage("login error: ", new FacesMessage("Exedio el numero de intentos"));
	  	   			
	  	   		}
				} catch (Exception e) {
				    FacesContext.getCurrentInstance().addMessage("login error: ", new FacesMessage("Usuario O Contrasena Invalidos"));
				}
	   
	   }
		
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





	public String getNewPass() {
		return newPass;
	}

	public void setNewPass(String newPass) {
		this.newPass = newPass;
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

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Time getFechaAuditoria() {
		return fechaAuditoria;
	}


	public void setFechaAuditoria(Time fechaAuditoria) {
		this.fechaAuditoria = fechaAuditoria;
	}


	public String getOperacion() {
		return operacion;
	}


	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}


	public String getTablaAuditoria() {
		return tablaAuditoria;
	}


	public void setTablaAuditoria(String tablaAuditoria) {
		this.tablaAuditoria = tablaAuditoria;
	}


	public String getUsuarioId() {
		return usuarioId;
	}


	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}


	public AuditoriaService getAuditoriaService() {
		return auditoriaService;
	}


	public void setAuditoriaService(AuditoriaService auditoriaService) {
		this.auditoriaService = auditoriaService;
	}


	
}