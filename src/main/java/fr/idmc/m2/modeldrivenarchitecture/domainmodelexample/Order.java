package fr.idmc.m2.modeldrivenarchitecture.domainmodelexample;

import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.*;

@Entity // Pour associer la classe à une table dans la base
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table( name = "ORDER") 
public class Order {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_order")
    protected int id;
	
	@Column(name = "delivery_instructions", nullable=false)
	protected String deliveryInstructions;
	
	@Column(name = "order_number")
	protected String orderNumber;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date")
	protected Date date;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	protected List<Transaction> transaction = new ArrayList<>();
	
	@OneToMany(mappedBy = "LineItem", cascade = CascadeType.ALL)
	protected List<LineItem> items = new ArrayList<>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_account")
    private Account account = new Account ();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_status")
    private OrderStatus status = new OrderStatus ();
	

}
