package io.onedev.server.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import io.onedev.server.model.support.QuerySetting;
import io.onedev.server.model.support.QuerySubscriptionSupport;
import io.onedev.server.model.support.QueryWatchSupport;
import io.onedev.server.model.support.build.NamedBuildQuery;

@Entity
@Table(
		indexes={@Index(columnList="g_project_id"), @Index(columnList="g_user_id")}, 
		uniqueConstraints={@UniqueConstraint(columnNames={"g_project_id", "g_user_id"})}
)
public class BuildQuerySetting extends QuerySetting<NamedBuildQuery> {

	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(nullable=false)
	private Project project;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(nullable=false)
	private User user;

	@Lob
	@Column(nullable=false, length=65535)
	private ArrayList<NamedBuildQuery> userQueries = new ArrayList<>();

	@Override
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public ArrayList<NamedBuildQuery> getUserQueries() {
		return userQueries;
	}

	@Override
	public void setUserQueries(ArrayList<NamedBuildQuery> userQueries) {
		this.userQueries = userQueries;
	}

	@Override
	public QueryWatchSupport<NamedBuildQuery> getQueryWatchSupport() {
		return null;
	}

	@Override
	public QuerySubscriptionSupport<NamedBuildQuery> getQuerySubscriptionSupport() {
		return null;
	}
	
}