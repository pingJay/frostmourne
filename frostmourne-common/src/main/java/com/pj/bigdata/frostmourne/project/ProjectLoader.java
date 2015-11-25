package com.pj.bigdata.frostmourne.project;

import com.pj.bigdata.frostmourne.database.FrostmourneDataSource;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * 项目对象的数据库操作
 * Created by pingjie on 15-11-24.
 */
public class ProjectLoader {
    public static final Logger logger = Logger.getLogger(ProjectLoader.class);

    public synchronized void createNewProject(Project project) {
        Connection connection = FrostmourneDataSource.getInstance().getconnection();
        QueryRunner queryRunner = new QueryRunner();
        ProjectResultHandler projectResultHandler = new ProjectResultHandler();

    }

    public List<Project> fetchAllProject() throws ProjectManagerException {
        Connection connection = FrostmourneDataSource.getInstance().getconnection();
        QueryRunner queryRunner = new QueryRunner();

        ProjectResultHandler handler = new ProjectResultHandler();
        List<Project> projectList = null;
        try {
            projectList = queryRunner.query(connection,ProjectResultHandler.SELECT_ALL_PROJECT,handler);
        } catch (SQLException e) {
            logger.error(e);
            throw new ProjectManagerException("Error retrieving all projects",e);
        }finally {
            DbUtils.closeQuietly(connection);
        }
        return projectList;
    }

    public Project fetchProjectById(int id) throws ProjectManagerException {
        Connection connection = FrostmourneDataSource.getInstance().getconnection();
        QueryRunner queryRunner = new QueryRunner();
        ProjectResultHandler handler = new ProjectResultHandler();

        List<Project> projects = null;
        try {
            projects = queryRunner.query(connection,ProjectResultHandler.SELECT_PROJECT_BY_ID,handler,id);
            if (projects.isEmpty()) {
                throw new ProjectManagerException("No project with id " + id
                        + " exists in db.");
            }
        } catch (SQLException e) {
            logger.error(e);
            throw new ProjectManagerException("Query for existing project is failed.project id " + id,e);
        }finally {
            DbUtils.closeQuietly(connection);
        }
        return projects.get(0);
    }

    public List<Project> fetchAllProjectByUser(String username) throws ProjectManagerException {
        Connection connection = FrostmourneDataSource.getInstance().getconnection();
        QueryRunner queryRunner = new QueryRunner();
        ProjectResultHandler handler = new ProjectResultHandler();

        List<Project> projects = null;
        try {
            projects = queryRunner.query(connection,ProjectResultHandler.SELECT_ALL_PROJECT_BY_USER,handler,username);
        } catch (SQLException e) {
            logger.error(e);
            throw new ProjectManagerException("Error retrieving all projects by user.user_name " + username,e);
        }finally {
            DbUtils.closeQuietly(connection);
        }
        return projects;
    }

    public Project fetchProjectByName(String projectName) throws ProjectManagerException {
        Connection connection = FrostmourneDataSource.getInstance().getconnection();
        QueryRunner queryRunner = new QueryRunner();
        ProjectResultHandler handler = new ProjectResultHandler();

        List<Project> projects = null;
        try {
            projects = queryRunner.query(connection,ProjectResultHandler.SELECT_PROJECT_BY_NAME,handler,projectName);
            if (projects.isEmpty()) {
                throw new ProjectManagerException("No project with name " + projectName
                        + " exists in db.");
            }
        } catch (SQLException e) {
            logger.error(e);
            throw new ProjectManagerException("Query for existing by projectName project is failed.project name " + projectName,e);
        }finally {
            DbUtils.closeQuietly(connection);
        }
        return projects.get(0);
    }
    /**
     * ResultSetHandler实现类
     */
    public static class ProjectResultHandler implements ResultSetHandler<List<Project>> {

        private static final String SELECT_PROJECT_BY_ID =
                "select * from projects where id=?";

        private static final String SELECT_ALL_PROJECT_BY_USER =
                "select * from projects where user_name=?";

        private static final String SELECT_PROJECT_BY_NAME =
                "select * from projects where project_name=?";

        private static final String SELECT_ALL_PROJECT =
                "select * from projects where project_name=?";

        public List<Project> handle(ResultSet resultSet) throws SQLException {
            if (!resultSet.next()){
                return Collections.emptyList();
            }

            List<Project> projectList = new ArrayList<Project>();

            while(resultSet.next()) {
                Project project = new Project();
                int id = resultSet.getInt(1);
                String userName = resultSet.getString(2);
                Date createTime = resultSet.getDate(3);
                Date lastUpadteTime = resultSet.getDate(4);
                String projectName = resultSet.getString(5);
                String jobType = resultSet.getString(6);
                String appPath = resultSet.getString(7);
                String className = resultSet.getString(8);
                String runArgs = resultSet.getString(9);
                String runCron = resultSet.getString(10);
                String businessType = resultSet.getString(11);
                String desc = resultSet.getString(12);
                int period = resultSet.getInt(13);
                String speciaHost = resultSet.getString(14);
                String businessTime = resultSet.getString(15);
                int retryCount = resultSet.getInt(16);
                int retryInterval = resultSet.getInt(17);

                project.setId(id);
                project.setUserName(userName);
                project.setCreatetime(createTime);
                project.setLastUpdateTime(lastUpadteTime);
                project.setProjectName(projectName);
                project.setJobType(jobType);
                project.setAppPath(appPath);
                project.setClassName(className);
                project.setRunArgs(runArgs);
                project.setRunCron(runCron);
                project.setBusinessType(businessType);
                project.setDesc(desc);
                project.setPeiod(period);
                project.setSpecialHost(speciaHost);
                project.setBusinessTime(businessTime);
                project.setRetryCount(retryCount);
                project.setRetryInterval(retryInterval);

                projectList.add(project);
            }
            return projectList;
        }
    }
}
