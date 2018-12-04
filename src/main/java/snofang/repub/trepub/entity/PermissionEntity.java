package snofang.repub.trepub.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name="permission")
public class PermissionEntity extends BaseIdEntity {

	private static final long serialVersionUID = 1L;

	private String name;

}
