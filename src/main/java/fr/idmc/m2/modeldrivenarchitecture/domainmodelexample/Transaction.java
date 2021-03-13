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

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table( name = "TRANSACTION" ) 
public class Transaction {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_transaction")
    private Integer id;
	
	@Column(name = "order_number", nullable=false)	
	private String orderNumber;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date")
	protected Date date;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_order")
    private Order order = new Order ();
	
	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
	protected List<Account> accounts = new ArrayList<>();

}