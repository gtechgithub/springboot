package com.javapoint;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("app")
public class ApplicationPropertiesPrefix {

	private String error;
	private List<Menu> menus = new ArrayList();
    private Compiler compiler = new Compiler();

	public String getError() {
		return error;
	}


	public void setError(String error) {
		this.error = error;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public Compiler getCompiler() {
		return compiler;
	}

	public void setCompiler(Compiler compiler) {
		this.compiler = compiler;
	}

	public static class Menu {
		private String title;
		private String path;
		private String name;
		
		
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getPath() {
			return path;
		}
		public void setPath(String path) {
			this.path = path;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
        @Override
        public String toString() {
            return "Menu{" +
                    "name='" + name + '\'' +
                    ", path='" + path + '\'' +
                    ", title='" + title + '\'' +
                    '}';
        }
	}
	
	
	
	public static class Compiler{
		
		private int timeout;
		private String outputFolder;

		
		public int getTimeout() {
			return timeout;
		}
		public void setTimeout(int timeout) {
			this.timeout = timeout;
		}
		public String getOutputFolder() {
			return outputFolder;
		}
		public void setOutputFolder(String outputFolder) {
			this.outputFolder = outputFolder;
		}
		
	      @Override
	        public String toString() {
	            return "Compiler{" +
	                    "timeout='" + timeout + '\'' +
	                    ", outputFolder='" + outputFolder + '\'' +
	                    '}';
	        }
	}
	
	@Override
	public String toString() {
		
		return "error:" + error + " Menus:" +  menus.toString() + " Compiler:" + compiler.toString(); 
	}
}
