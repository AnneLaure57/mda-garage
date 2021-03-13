package fr.idmc.m2.modeldrivenarchitecture.domainmodelexample;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table( name = "ACCOUNT" ) 
public class Account {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_account")
    private Integer id;
	
	@Column(name = "name", nullable=false)	
	private String name;
	
	@Column(name = "billing_adress", nullable=false)	
	private String billingAdress;
	
	@Column(name = "closed", nullable=false)	
	private Boolean closed;
	
	@Column(name = "delivery_adress", nullable=false)	
	private String deliveryAdress;
	
	@Column(name = "mail", nullable=false)	
	private String mail;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	protected List<Order> orders = new ArrayList<>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_transaction")
    private Transaction history = new Transaction ();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_basket")
    private ShoppingBasket basket = new ShoppingBasket ();

}
