package com.unbosque.mbController;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.springframework.dao.DataAccessException;

import com.unbosque.entidad.Departamento;
import com.unbosque.entidad.Ciudad;
import com.unbosque.entidad.Donto;
import com.unbosque.entidad.Proyecto;
import com.unbosque.entidad.Usuario;
import com.unbosque.service.DepartamentoService;
import com.unbosque.service.DontoService;
import com.unbosque.service.ProyectoService;

@ManagedBean(name = "PruebaDienteMBController")
@SessionScoped
public class PruebaDiente implements Serializable {

    private static final long serialVersionUID = -7809396168460749463L;

    // Spring Customer Service is injected...
    @ManagedProperty(value = "#{DontoService}")
    DontoService dontoService;
    

    public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
    
    private char t4; private char t5; private char t6; private char t7; private char t8; private char t9;
    private char t10; private char t11; private char t12; private char t13; private char t20; private char t21;
    private char t22; private char t23; private char t24; private char t25; private char t26; private char t27;
    private char t28; private char t29;
	
    private Integer d11; private Integer d12; private Integer d13; private Integer d14; private Integer d15;
    
    private Integer d21; private Integer d22; private Integer d23; private Integer d24; private Integer d25;

    private Integer d31; private Integer d32; private Integer d33; private Integer d34; private Integer d35;

    private Integer d41; private Integer d42; private Integer d43; private Integer d44; private Integer d45;

    private Integer d51; private Integer d52; private Integer d53; private Integer d54; private Integer d55;

    private Integer d61; private Integer d62; private Integer d63; private Integer d64; private Integer d65;

    private Integer d71; private Integer d72; private Integer d73; private Integer d74; private Integer d75;

    private Integer d81; private Integer d82; private Integer d83; private Integer d84; private Integer d85;

    private Integer d91; private Integer d92; private Integer d93; private Integer d94; private Integer d95;

    private Integer d101; private Integer d102; private Integer d103; private Integer d104; private Integer d105;

    private Integer d111; private Integer d112; private Integer d113; private Integer d114; private Integer d115;

    private Integer d121; private Integer d122; private Integer d123; private Integer d124; private Integer d125;

    private Integer d131; private Integer d132; private Integer d133; private Integer d134; private Integer d135;

    private Integer d141; private Integer d142; private Integer d143; private Integer d144; private Integer d145;

    private Integer d151; private Integer d152; private Integer d153; private Integer d154; private Integer d155;

    private Integer d161; private Integer d162; private Integer d163; private Integer d164; private Integer d165;

    private Integer d171; private Integer d172; private Integer d173; private Integer d174; private Integer d175;

    private Integer d181; private Integer d182; private Integer d183; private Integer d184; private Integer d185;

    private Integer d191; private Integer d192; private Integer d193; private Integer d194; private Integer d195;

    private Integer d201; private Integer d202; private Integer d203; private Integer d204; private Integer d205;

    private Integer d211; private Integer d212; private Integer d213; private Integer d214; private Integer d215;

    private Integer d221; private Integer d222; private Integer d223; private Integer d224; private Integer d225;

    private Integer d231; private Integer d232; private Integer d233; private Integer d234; private Integer d235;

    private Integer d241; private Integer d242; private Integer d243; private Integer d244; private Integer d245;

    private Integer d251; private Integer d252; private Integer d253; private Integer d254; private Integer d255;

    private Integer d261; private Integer d262; private Integer d263; private Integer d264; private Integer d265;

    private Integer d271; private Integer d272; private Integer d273; private Integer d274; private Integer d275;

    private Integer d281; private Integer d282; private Integer d283; private Integer d284; private Integer d285;

    private Integer d291; private Integer d292; private Integer d293; private Integer d294; private Integer d295;

    private Integer d301; private Integer d302; private Integer d303; private Integer d304; private Integer d305;

    private Integer d311; private Integer d312; private Integer d313; private Integer d314; private Integer d315;

    private Integer d321; private Integer d322; private Integer d323; private Integer d324; private Integer d325;

    private String c1; private String c2; private String c3; private String c4; private String c5; 
    private String c6; private String c7; private String c8; private String c9; private String c10;
    private String c11; private String c12; private String c13; private String c14; private String c15;
    private String c16; private String c17; private String c18; private String c19; private String c20; 
    private String c21; private String c24; private String c27; private String c29; private String c31;
    private String c22; private String c25; private String c28; private String c30; private String c32;
    private String c23; private String c26;
    
	List<Donto> dontoList;
	
	private String identificacion;
    @PostConstruct
    public void init() {
    	dontoList = new ArrayList<Donto>();
    	dontoList.addAll(getDontoService().getDontos());
        
    }
    
    public void save(){
    	if(getT4()=='S'||getT5()=='S'||getT6()=='S'||getT7()=='S'||getT8()=='S'||getT9()=='S'||getT10()=='S'||getT11()=='S'||getT12()=='S'||getT13()=='S'||getT20()=='S'||getT21()=='S'||getT22()=='S'||getT23()=='S'||getT24()=='S'||getT25()=='S'||getT26()=='S'||getT27()=='S'||getT28()=='S'||getT29()=='S'){
    		RequestContext context = RequestContext.getCurrentInstance();
    		context.execute("PF('myDialogVar').show();");

    	}else{
    		
    
    Donto don = new Donto();
    
    don.setT4(getT4()); don.setT5(getT5()); don.setT6(getT6()); don.setT7(getT7()); don.setT8(getT8()); 
    don.setT10(getT10()); don.setT9(getT9()); don.setT11(getT11()); don.setT12(getT12()); don.setT13(getT13());
    don.setT20(getT20()); don.setT21(getT21()); don.setT22(getT22()); don.setT23(getT23()); don.setT24(getT24());
    don.setT25(getT25()); don.setT26(getT26()); don.setT27(getT27()); don.setT28(getT28()); don.setT29(getT29());
    
    don.setCd11(getD11()); don.setCd12(getD12()); don.setCd13(getD13()); don.setCd14(getD14()); don.setCd15(getD15()); 
    don.setCd21(getD21()); don.setCd22(getD22()); don.setCd23(getD23()); don.setCd24(getD24()); don.setCd25(getD25());
    don.setCd31(getD31()); don.setCd32(getD32()); don.setCd33(getD33()); don.setCd34(getD34()); don.setCd35(getD35());
    don.setCd41(getD41()); don.setCd42(getD42()); don.setCd43(getD43()); don.setCd44(getD44()); don.setCd45(getD45());
    don.setCd51(getD51()); don.setCd52(getD52()); don.setCd53(getD53()); don.setCd54(getD54()); don.setCd55(getD55());
    don.setCd61(getD61()); don.setCd62(getD62()); don.setCd63(getD63()); don.setCd64(getD64()); don.setCd65(getD65());
    don.setCd71(getD71()); don.setCd72(getD72()); don.setCd73(getD73()); don.setCd74(getD74()); don.setCd75(getD75());
    don.setCd81(getD81()); don.setCd82(getD82()); don.setCd83(getD83()); don.setCd84(getD84()); don.setCd85(getD85());
    don.setCd91(getD91()); don.setCd92(getD92()); don.setCd93(getD93()); don.setCd94(getD94()); don.setCd95(getD95());
    
    don.setCd101(getD101()); don.setCd102(getD102()); don.setCd103(getD103()); don.setCd104(getD104()); don.setCd105(getD105());
    don.setCd111(getD111()); don.setCd112(getD112()); don.setCd113(getD113()); don.setCd114(getD114()); don.setCd105(getD115());
    don.setCd121(getD121()); don.setCd122(getD122()); don.setCd123(getD123()); don.setCd124(getD124()); don.setCd105(getD125());
    don.setCd131(getD131()); don.setCd132(getD132()); don.setCd133(getD133()); don.setCd134(getD134()); don.setCd105(getD135());
    don.setCd141(getD141()); don.setCd142(getD142()); don.setCd143(getD143()); don.setCd144(getD144()); don.setCd105(getD145());
    don.setCd151(getD151()); don.setCd152(getD152()); don.setCd153(getD153()); don.setCd154(getD154()); don.setCd105(getD155());
    don.setCd161(getD161()); don.setCd162(getD162()); don.setCd163(getD163()); don.setCd164(getD164()); don.setCd105(getD165());
    don.setCd171(getD171()); don.setCd172(getD172()); don.setCd173(getD173()); don.setCd174(getD174()); don.setCd105(getD175());
    don.setCd181(getD181()); don.setCd182(getD182()); don.setCd183(getD183()); don.setCd184(getD184()); don.setCd105(getD185());
    don.setCd191(getD191()); don.setCd192(getD192()); don.setCd193(getD193()); don.setCd194(getD194()); don.setCd105(getD195());
    
    don.setCd201(getD201()); don.setCd202(getD202()); don.setCd203(getD203()); don.setCd204(getD204()); don.setCd205(getD205());
    don.setCd211(getD211()); don.setCd212(getD212()); don.setCd213(getD213()); don.setCd214(getD214()); don.setCd215(getD215());
    don.setCd221(getD221()); don.setCd222(getD222()); don.setCd223(getD223()); don.setCd224(getD224()); don.setCd225(getD225());
    don.setCd231(getD231()); don.setCd232(getD232()); don.setCd233(getD233()); don.setCd234(getD234()); don.setCd235(getD235());
    don.setCd241(getD241()); don.setCd242(getD242()); don.setCd243(getD243()); don.setCd244(getD244()); don.setCd245(getD245());
    don.setCd251(getD251()); don.setCd252(getD252()); don.setCd253(getD253()); don.setCd254(getD254()); don.setCd255(getD255());
    don.setCd261(getD261()); don.setCd262(getD262()); don.setCd263(getD263()); don.setCd264(getD264()); don.setCd265(getD265());
    don.setCd271(getD271()); don.setCd272(getD272()); don.setCd273(getD273()); don.setCd274(getD274()); don.setCd275(getD275());
    don.setCd281(getD281()); don.setCd282(getD282()); don.setCd283(getD283()); don.setCd284(getD284()); don.setCd285(getD285());
    don.setCd291(getD291()); don.setCd292(getD292()); don.setCd293(getD293()); don.setCd294(getD294()); don.setCd295(getD295());

    don.setCd301(getD301()); don.setCd302(getD302()); don.setCd303(getD303()); don.setCd304(getD304()); don.setCd305(getD305());
    don.setCd311(getD311()); don.setCd312(getD312()); don.setCd313(getD313()); don.setCd314(getD314()); don.setCd315(getD315());
    don.setCd321(getD321()); don.setCd322(getD322()); don.setCd323(getD323()); don.setCd324(getD324()); don.setCd325(getD325());    
    
    getDontoService().addDonto(don);
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Guardado exitosamente!"));

    }
    }


    public void modifica1(RowEditEvent event){
    	
    	System.out.println("asdas");
//        don.setCd11(getD11()); don.setCd12(getD12()); don.setCd13(getD13()); don.setCd14(getD14()); don.setCd15(getD15()); 
//        getDontoService().updateDonto(don);
    }



	public Integer getD11() {
		return d11;
	}






	public void setD11(Integer d11) {
		this.d11 = d11;
	}






	public Integer getD12() {
		return d12;
	}






	public void setD12(Integer d12) {
		this.d12 = d12;
	}






	public Integer getD13() {
		return d13;
	}






	public void setD13(Integer d13) {
		this.d13 = d13;
	}






	public Integer getD14() {
		return d14;
	}






	public void setD14(Integer d14) {
		this.d14 = d14;
	}






	public Integer getD15() {
		return d15;
	}






	public void setD15(Integer d15) {
		this.d15 = d15;
	}






	public Integer getD21() {
		return d21;
	}






	public void setD21(Integer d21) {
		this.d21 = d21;
	}






	public Integer getD22() {
		return d22;
	}






	public void setD22(Integer d22) {
		this.d22 = d22;
	}






	public Integer getD23() {
		return d23;
	}






	public void setD23(Integer d23) {
		this.d23 = d23;
	}






	public Integer getD24() {
		return d24;
	}






	public void setD24(Integer d24) {
		this.d24 = d24;
	}






	public Integer getD25() {
		return d25;
	}






	public void setD25(Integer d25) {
		this.d25 = d25;
	}






	public Integer getD31() {
		return d31;
	}






	public void setD31(Integer d31) {
		this.d31 = d31;
	}






	public Integer getD32() {
		return d32;
	}






	public void setD32(Integer d32) {
		this.d32 = d32;
	}






	public Integer getD33() {
		return d33;
	}






	public void setD33(Integer d33) {
		this.d33 = d33;
	}






	public Integer getD34() {
		return d34;
	}






	public void setD34(Integer d34) {
		this.d34 = d34;
	}






	public Integer getD35() {
		return d35;
	}






	public void setD35(Integer d35) {
		this.d35 = d35;
	}






	public Integer getD41() {
		return d41;
	}






	public void setD41(Integer d41) {
		this.d41 = d41;
	}






	public Integer getD42() {
		return d42;
	}






	public void setD42(Integer d42) {
		this.d42 = d42;
	}






	public Integer getD43() {
		return d43;
	}






	public void setD43(Integer d43) {
		this.d43 = d43;
	}






	public Integer getD44() {
		return d44;
	}






	public void setD44(Integer d44) {
		this.d44 = d44;
	}






	public Integer getD45() {
		return d45;
	}






	public void setD45(Integer d45) {
		this.d45 = d45;
	}






	public Integer getD51() {
		return d51;
	}






	public void setD51(Integer d51) {
		this.d51 = d51;
	}






	public Integer getD52() {
		return d52;
	}






	public void setD52(Integer d52) {
		this.d52 = d52;
	}






	public Integer getD53() {
		return d53;
	}






	public void setD53(Integer d53) {
		this.d53 = d53;
	}






	public Integer getD54() {
		return d54;
	}






	public void setD54(Integer d54) {
		this.d54 = d54;
	}






	public Integer getD55() {
		return d55;
	}






	public void setD55(Integer d55) {
		this.d55 = d55;
	}






	public Integer getD61() {
		return d61;
	}






	public void setD61(Integer d61) {
		this.d61 = d61;
	}






	public Integer getD62() {
		return d62;
	}






	public void setD62(Integer d62) {
		this.d62 = d62;
	}






	public Integer getD63() {
		return d63;
	}






	public void setD63(Integer d63) {
		this.d63 = d63;
	}






	public Integer getD64() {
		return d64;
	}






	public void setD64(Integer d64) {
		this.d64 = d64;
	}






	public Integer getD65() {
		return d65;
	}






	public void setD65(Integer d65) {
		this.d65 = d65;
	}






	public Integer getD71() {
		return d71;
	}






	public void setD71(Integer d71) {
		this.d71 = d71;
	}






	public Integer getD72() {
		return d72;
	}






	public void setD72(Integer d72) {
		this.d72 = d72;
	}






	public Integer getD73() {
		return d73;
	}






	public void setD73(Integer d73) {
		this.d73 = d73;
	}






	public Integer getD74() {
		return d74;
	}






	public void setD74(Integer d74) {
		this.d74 = d74;
	}






	public Integer getD75() {
		return d75;
	}






	public void setD75(Integer d75) {
		this.d75 = d75;
	}






	public Integer getD81() {
		return d81;
	}






	public void setD81(Integer d81) {
		this.d81 = d81;
	}






	public Integer getD82() {
		return d82;
	}






	public void setD82(Integer d82) {
		this.d82 = d82;
	}






	public Integer getD83() {
		return d83;
	}






	public void setD83(Integer d83) {
		this.d83 = d83;
	}






	public Integer getD84() {
		return d84;
	}






	public void setD84(Integer d84) {
		this.d84 = d84;
	}






	public Integer getD85() {
		return d85;
	}






	public void setD85(Integer d85) {
		this.d85 = d85;
	}






	public Integer getD91() {
		return d91;
	}






	public void setD91(Integer d91) {
		this.d91 = d91;
	}






	public Integer getD92() {
		return d92;
	}






	public void setD92(Integer d92) {
		this.d92 = d92;
	}






	public Integer getD93() {
		return d93;
	}






	public void setD93(Integer d93) {
		this.d93 = d93;
	}






	public Integer getD94() {
		return d94;
	}






	public void setD94(Integer d94) {
		this.d94 = d94;
	}






	public Integer getD95() {
		return d95;
	}






	public void setD95(Integer d95) {
		this.d95 = d95;
	}






	public Integer getD101() {
		return d101;
	}






	public void setD101(Integer d101) {
		this.d101 = d101;
	}






	public Integer getD102() {
		return d102;
	}






	public void setD102(Integer d102) {
		this.d102 = d102;
	}






	public Integer getD103() {
		return d103;
	}






	public void setD103(Integer d103) {
		this.d103 = d103;
	}






	public Integer getD104() {
		return d104;
	}






	public void setD104(Integer d104) {
		this.d104 = d104;
	}






	public Integer getD105() {
		return d105;
	}






	public void setD105(Integer d105) {
		this.d105 = d105;
	}






	public Integer getD111() {
		return d111;
	}






	public void setD111(Integer d111) {
		this.d111 = d111;
	}






	public Integer getD112() {
		return d112;
	}






	public void setD112(Integer d112) {
		this.d112 = d112;
	}






	public Integer getD113() {
		return d113;
	}






	public void setD113(Integer d113) {
		this.d113 = d113;
	}






	public Integer getD114() {
		return d114;
	}






	public void setD114(Integer d114) {
		this.d114 = d114;
	}






	public Integer getD115() {
		return d115;
	}






	public void setD115(Integer d115) {
		this.d115 = d115;
	}






	public Integer getD121() {
		return d121;
	}






	public void setD121(Integer d121) {
		this.d121 = d121;
	}






	public Integer getD122() {
		return d122;
	}






	public void setD122(Integer d122) {
		this.d122 = d122;
	}






	public Integer getD123() {
		return d123;
	}






	public void setD123(Integer d123) {
		this.d123 = d123;
	}






	public Integer getD124() {
		return d124;
	}






	public void setD124(Integer d124) {
		this.d124 = d124;
	}






	public Integer getD125() {
		return d125;
	}






	public void setD125(Integer d125) {
		this.d125 = d125;
	}






	public Integer getD131() {
		return d131;
	}






	public void setD131(Integer d131) {
		this.d131 = d131;
	}






	public Integer getD132() {
		return d132;
	}






	public void setD132(Integer d132) {
		this.d132 = d132;
	}






	public Integer getD133() {
		return d133;
	}






	public void setD133(Integer d133) {
		this.d133 = d133;
	}






	public Integer getD134() {
		return d134;
	}






	public void setD134(Integer d134) {
		this.d134 = d134;
	}






	public Integer getD135() {
		return d135;
	}






	public void setD135(Integer d135) {
		this.d135 = d135;
	}






	public Integer getD141() {
		return d141;
	}






	public void setD141(Integer d141) {
		this.d141 = d141;
	}






	public Integer getD142() {
		return d142;
	}






	public void setD142(Integer d142) {
		this.d142 = d142;
	}






	public Integer getD143() {
		return d143;
	}






	public void setD143(Integer d143) {
		this.d143 = d143;
	}






	public Integer getD144() {
		return d144;
	}






	public void setD144(Integer d144) {
		this.d144 = d144;
	}






	public Integer getD145() {
		return d145;
	}






	public void setD145(Integer d145) {
		this.d145 = d145;
	}






	public Integer getD151() {
		return d151;
	}






	public void setD151(Integer d151) {
		this.d151 = d151;
	}






	public Integer getD152() {
		return d152;
	}






	public void setD152(Integer d152) {
		this.d152 = d152;
	}






	public Integer getD153() {
		return d153;
	}






	public void setD153(Integer d153) {
		this.d153 = d153;
	}






	public Integer getD154() {
		return d154;
	}






	public void setD154(Integer d154) {
		this.d154 = d154;
	}






	public Integer getD155() {
		return d155;
	}






	public void setD155(Integer d155) {
		this.d155 = d155;
	}






	public Integer getD161() {
		return d161;
	}






	public void setD161(Integer d161) {
		this.d161 = d161;
	}






	public Integer getD162() {
		return d162;
	}






	public void setD162(Integer d162) {
		this.d162 = d162;
	}






	public Integer getD163() {
		return d163;
	}






	public void setD163(Integer d163) {
		this.d163 = d163;
	}






	public Integer getD164() {
		return d164;
	}






	public void setD164(Integer d164) {
		this.d164 = d164;
	}






	public Integer getD165() {
		return d165;
	}






	public void setD165(Integer d165) {
		this.d165 = d165;
	}






	public Integer getD171() {
		return d171;
	}






	public void setD171(Integer d171) {
		this.d171 = d171;
	}






	public Integer getD172() {
		return d172;
	}






	public void setD172(Integer d172) {
		this.d172 = d172;
	}






	public Integer getD173() {
		return d173;
	}






	public void setD173(Integer d173) {
		this.d173 = d173;
	}






	public Integer getD174() {
		return d174;
	}






	public void setD174(Integer d174) {
		this.d174 = d174;
	}






	public Integer getD175() {
		return d175;
	}






	public void setD175(Integer d175) {
		this.d175 = d175;
	}






	public Integer getD181() {
		return d181;
	}






	public void setD181(Integer d181) {
		this.d181 = d181;
	}






	public Integer getD182() {
		return d182;
	}






	public void setD182(Integer d182) {
		this.d182 = d182;
	}






	public Integer getD183() {
		return d183;
	}






	public void setD183(Integer d183) {
		this.d183 = d183;
	}






	public Integer getD184() {
		return d184;
	}






	public void setD184(Integer d184) {
		this.d184 = d184;
	}






	public Integer getD185() {
		return d185;
	}






	public void setD185(Integer d185) {
		this.d185 = d185;
	}






	public Integer getD191() {
		return d191;
	}






	public void setD191(Integer d191) {
		this.d191 = d191;
	}






	public Integer getD192() {
		return d192;
	}






	public void setD192(Integer d192) {
		this.d192 = d192;
	}






	public Integer getD193() {
		return d193;
	}






	public void setD193(Integer d193) {
		this.d193 = d193;
	}






	public Integer getD194() {
		return d194;
	}






	public void setD194(Integer d194) {
		this.d194 = d194;
	}






	public Integer getD195() {
		return d195;
	}






	public void setD195(Integer d195) {
		this.d195 = d195;
	}






	public Integer getD201() {
		return d201;
	}






	public void setD201(Integer d201) {
		this.d201 = d201;
	}






	public Integer getD202() {
		return d202;
	}






	public void setD202(Integer d202) {
		this.d202 = d202;
	}






	public Integer getD203() {
		return d203;
	}






	public void setD203(Integer d203) {
		this.d203 = d203;
	}






	public Integer getD204() {
		return d204;
	}






	public void setD204(Integer d204) {
		this.d204 = d204;
	}






	public Integer getD205() {
		return d205;
	}






	public void setD205(Integer d205) {
		this.d205 = d205;
	}






	public Integer getD211() {
		return d211;
	}






	public void setD211(Integer d211) {
		this.d211 = d211;
	}






	public Integer getD212() {
		return d212;
	}






	public void setD212(Integer d212) {
		this.d212 = d212;
	}






	public Integer getD213() {
		return d213;
	}






	public void setD213(Integer d213) {
		this.d213 = d213;
	}






	public Integer getD214() {
		return d214;
	}






	public void setD214(Integer d214) {
		this.d214 = d214;
	}






	public Integer getD215() {
		return d215;
	}






	public void setD215(Integer d215) {
		this.d215 = d215;
	}






	public Integer getD221() {
		return d221;
	}






	public void setD221(Integer d221) {
		this.d221 = d221;
	}






	public Integer getD222() {
		return d222;
	}






	public void setD222(Integer d222) {
		this.d222 = d222;
	}






	public Integer getD223() {
		return d223;
	}






	public void setD223(Integer d223) {
		this.d223 = d223;
	}






	public Integer getD224() {
		return d224;
	}






	public void setD224(Integer d224) {
		this.d224 = d224;
	}






	public Integer getD225() {
		return d225;
	}






	public void setD225(Integer d225) {
		this.d225 = d225;
	}






	public Integer getD231() {
		return d231;
	}






	public void setD231(Integer d231) {
		this.d231 = d231;
	}






	public Integer getD232() {
		return d232;
	}






	public void setD232(Integer d232) {
		this.d232 = d232;
	}






	public Integer getD233() {
		return d233;
	}






	public void setD233(Integer d233) {
		this.d233 = d233;
	}






	public Integer getD234() {
		return d234;
	}






	public void setD234(Integer d234) {
		this.d234 = d234;
	}






	public Integer getD235() {
		return d235;
	}






	public void setD235(Integer d235) {
		this.d235 = d235;
	}






	public Integer getD241() {
		return d241;
	}






	public void setD241(Integer d241) {
		this.d241 = d241;
	}






	public Integer getD242() {
		return d242;
	}






	public void setD242(Integer d242) {
		this.d242 = d242;
	}






	public Integer getD243() {
		return d243;
	}






	public void setD243(Integer d243) {
		this.d243 = d243;
	}






	public Integer getD244() {
		return d244;
	}






	public void setD244(Integer d244) {
		this.d244 = d244;
	}






	public Integer getD245() {
		return d245;
	}






	public void setD245(Integer d245) {
		this.d245 = d245;
	}






	public Integer getD251() {
		return d251;
	}






	public void setD251(Integer d251) {
		this.d251 = d251;
	}






	public Integer getD252() {
		return d252;
	}






	public void setD252(Integer d252) {
		this.d252 = d252;
	}






	public Integer getD253() {
		return d253;
	}






	public void setD253(Integer d253) {
		this.d253 = d253;
	}






	public Integer getD254() {
		return d254;
	}






	public void setD254(Integer d254) {
		this.d254 = d254;
	}






	public Integer getD255() {
		return d255;
	}






	public void setD255(Integer d255) {
		this.d255 = d255;
	}






	public Integer getD261() {
		return d261;
	}






	public void setD261(Integer d261) {
		this.d261 = d261;
	}






	public Integer getD262() {
		return d262;
	}






	public void setD262(Integer d262) {
		this.d262 = d262;
	}






	public Integer getD263() {
		return d263;
	}






	public void setD263(Integer d263) {
		this.d263 = d263;
	}






	public Integer getD264() {
		return d264;
	}






	public void setD264(Integer d264) {
		this.d264 = d264;
	}






	public Integer getD265() {
		return d265;
	}






	public void setD265(Integer d265) {
		this.d265 = d265;
	}






	public Integer getD271() {
		return d271;
	}






	public void setD271(Integer d271) {
		this.d271 = d271;
	}






	public Integer getD272() {
		return d272;
	}






	public void setD272(Integer d272) {
		this.d272 = d272;
	}






	public Integer getD273() {
		return d273;
	}






	public void setD273(Integer d273) {
		this.d273 = d273;
	}






	public Integer getD274() {
		return d274;
	}






	public void setD274(Integer d274) {
		this.d274 = d274;
	}






	public Integer getD275() {
		return d275;
	}






	public void setD275(Integer d275) {
		this.d275 = d275;
	}






	public Integer getD281() {
		return d281;
	}






	public void setD281(Integer d281) {
		this.d281 = d281;
	}






	public Integer getD282() {
		return d282;
	}






	public void setD282(Integer d282) {
		this.d282 = d282;
	}






	public Integer getD283() {
		return d283;
	}






	public void setD283(Integer d283) {
		this.d283 = d283;
	}






	public Integer getD284() {
		return d284;
	}






	public void setD284(Integer d284) {
		this.d284 = d284;
	}






	public Integer getD285() {
		return d285;
	}






	public void setD285(Integer d285) {
		this.d285 = d285;
	}






	public Integer getD291() {
		return d291;
	}






	public void setD291(Integer d291) {
		this.d291 = d291;
	}






	public Integer getD292() {
		return d292;
	}






	public void setD292(Integer d292) {
		this.d292 = d292;
	}






	public Integer getD293() {
		return d293;
	}






	public void setD293(Integer d293) {
		this.d293 = d293;
	}






	public Integer getD294() {
		return d294;
	}






	public void setD294(Integer d294) {
		this.d294 = d294;
	}






	public Integer getD295() {
		return d295;
	}






	public void setD295(Integer d295) {
		this.d295 = d295;
	}






	public Integer getD301() {
		return d301;
	}

	





	public void setD301(Integer d301) {
		this.d301 = d301;
	}






	public Integer getD302() {
		return d302;
	}






	public void setD302(Integer d302) {
		this.d302 = d302;
	}






	public Integer getD303() {
		return d303;
	}






	public void setD303(Integer d303) {
		this.d303 = d303;
	}






	public Integer getD304() {
		return d304;
	}






	public void setD304(Integer d304) {
		this.d304 = d304;
	}






	public Integer getD305() {
		return d305;
	}






	public void setD305(Integer d305) {
		this.d305 = d305;
	}






	public Integer getD311() {
		return d311;
	}






	public void setD311(Integer d311) {
		this.d311 = d311;
	}






	public Integer getD312() {
		return d312;
	}






	public void setD312(Integer d312) {
		this.d312 = d312;
	}






	public Integer getD313() {
		return d313;
	}






	public void setD313(Integer d313) {
		this.d313 = d313;
	}






	public Integer getD314() {
		return d314;
	}






	public void setD314(Integer d314) {
		this.d314 = d314;
	}






	public Integer getD315() {
		return d315;
	}






	public void setD315(Integer d315) {
		this.d315 = d315;
	}






	public Integer getD321() {
		return d321;
	}






	public void setD321(Integer d321) {
		this.d321 = d321;
	}






	public Integer getD322() {
		return d322;
	}






	public void setD322(Integer d322) {
		this.d322 = d322;
	}






	public Integer getD323() {
		return d323;
	}






	public void setD323(Integer d323) {
		this.d323 = d323;
	}






	public Integer getD324() {
		return d324;
	}






	public void setD324(Integer d324) {
		this.d324 = d324;
	}






	public Integer getD325() {
		return d325;
	}






	public void setD325(Integer d325) {
		this.d325 = d325;
	}






	public String getC1() {
		return c1;
	}






	public void setC1(String c1) {
		this.c1 = c1;
	}






	public String getC2() {
		return c2;
	}






	public void setC2(String c2) {
		this.c2 = c2;
	}






	public String getC3() {
		return c3;
	}






	public void setC3(String c3) {
		this.c3 = c3;
	}






	public String getC4() {
		return c4;
	}






	public void setC4(String c4) {
		this.c4 = c4;
	}






	public String getC5() {
		return c5;
	}






	public void setC5(String c5) {
		this.c5 = c5;
	}






	public String getC6() {
		return c6;
	}






	public void setC6(String c6) {
		this.c6 = c6;
	}






	public String getC7() {
		return c7;
	}






	public void setC7(String c7) {
		this.c7 = c7;
	}






	public String getC8() {
		return c8;
	}






	public void setC8(String c8) {
		this.c8 = c8;
	}






	public String getC9() {
		return c9;
	}






	public void setC9(String c9) {
		this.c9 = c9;
	}






	public String getC10() {
		return c10;
	}






	public void setC10(String c10) {
		this.c10 = c10;
	}






	public String getC11() {
		return c11;
	}






	public void setC11(String c11) {
		this.c11 = c11;
	}






	public String getC12() {
		return c12;
	}






	public void setC12(String c12) {
		this.c12 = c12;
	}






	public String getC13() {
		return c13;
	}






	public void setC13(String c13) {
		this.c13 = c13;
	}






	public String getC14() {
		return c14;
	}






	public void setC14(String c14) {
		this.c14 = c14;
	}






	public String getC15() {
		return c15;
	}






	public void setC15(String c15) {
		this.c15 = c15;
	}






	public String getC16() {
		return c16;
	}






	public void setC16(String c16) {
		this.c16 = c16;
	}






	public String getC17() {
		return c17;
	}






	public void setC17(String c17) {
		this.c17 = c17;
	}






	public String getC18() {
		return c18;
	}






	public void setC18(String c18) {
		this.c18 = c18;
	}






	public String getC19() {
		return c19;
	}






	public void setC19(String c19) {
		this.c19 = c19;
	}






	public String getC20() {
		return c20;
	}






	public void setC20(String c20) {
		this.c20 = c20;
	}






	public String getC21() {
		return c21;
	}






	public void setC21(String c21) {
		this.c21 = c21;
	}






	public String getC24() {
		return c24;
	}






	public void setC24(String c24) {
		this.c24 = c24;
	}






	public String getC27() {
		return c27;
	}






	public void setC27(String c27) {
		this.c27 = c27;
	}






	public String getC29() {
		return c29;
	}






	public void setC29(String c29) {
		this.c29 = c29;
	}






	public String getC31() {
		return c31;
	}






	public void setC31(String c31) {
		this.c31 = c31;
	}






	public String getC22() {
		return c22;
	}






	public void setC22(String c22) {
		this.c22 = c22;
	}






	public String getC25() {
		return c25;
	}






	public void setC25(String c25) {
		this.c25 = c25;
	}






	public String getC28() {
		return c28;
	}






	public void setC28(String c28) {
		this.c28 = c28;
	}






	public String getC30() {
		return c30;
	}






	public void setC30(String c30) {
		this.c30 = c30;
	}






	public String getC32() {
		return c32;
	}






	public void setC32(String c32) {
		this.c32 = c32;
	}






	public String getC23() {
		return c23;
	}






	public void setC23(String c23) {
		this.c23 = c23;
	}






	public String getC26() {
		return c26;
	}






	public void setC26(String c26) {
		this.c26 = c26;
	}






	public DontoService getDontoService() {
		return dontoService;
	}






	public void setDontoService(DontoService dontoService) {
		this.dontoService = dontoService;
	}






	public char getT4() {
		return t4;
	}






	public void setT4(char t4) {
		this.t4 = t4;
	}






	public char getT5() {
		return t5;
	}






	public void setT5(char t5) {
		this.t5 = t5;
	}






	public char getT6() {
		return t6;
	}






	public void setT6(char t6) {
		this.t6 = t6;
	}






	public char getT7() {
		return t7;
	}






	public void setT7(char t7) {
		this.t7 = t7;
	}






	public char getT8() {
		return t8;
	}






	public void setT8(char t8) {
		this.t8 = t8;
	}






	public char getT9() {
		return t9;
	}






	public void setT9(char t9) {
		this.t9 = t9;
	}






	public char getT10() {
		return t10;
	}






	public void setT10(char t10) {
		this.t10 = t10;
	}






	public char getT11() {
		return t11;
	}






	public void setT11(char t11) {
		this.t11 = t11;
	}






	public char getT12() {
		return t12;
	}






	public void setT12(char t12) {
		this.t12 = t12;
	}






	public char getT13() {
		return t13;
	}






	public void setT13(char t13) {
		this.t13 = t13;
	}






	public char getT20() {
		return t20;
	}






	public void setT20(char t20) {
		this.t20 = t20;
	}






	public char getT21() {
		return t21;
	}






	public void setT21(char t21) {
		this.t21 = t21;
	}






	public char getT22() {
		return t22;
	}






	public void setT22(char t22) {
		this.t22 = t22;
	}






	public char getT23() {
		return t23;
	}






	public void setT23(char t23) {
		this.t23 = t23;
	}






	public char getT24() {
		return t24;
	}






	public void setT24(char t24) {
		this.t24 = t24;
	}






	public char getT25() {
		return t25;
	}






	public void setT25(char t25) {
		this.t25 = t25;
	}






	public char getT26() {
		return t26;
	}






	public void setT26(char t26) {
		this.t26 = t26;
	}






	public char getT27() {
		return t27;
	}






	public void setT27(char t27) {
		this.t27 = t27;
	}






	public char getT28() {
		return t28;
	}






	public void setT28(char t28) {
		this.t28 = t28;
	}






	public char getT29() {
		return t29;
	}






	public void setT29(char t29) {
		this.t29 = t29;
	}

	public List<Donto> getDontoList() {
		return dontoList;
	}

	public void setDontoList(List<Donto> dontoList) {
		this.dontoList = dontoList;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}


    
    }