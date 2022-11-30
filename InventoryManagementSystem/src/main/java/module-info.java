module tu.varna.ims {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires log4j;
    requires org.hibernate.orm.core;
    requires java.persistence;
    requires java.naming;
    requires java.sql;


    opens tu.varna.ims to javafx.fxml;
    exports tu.varna.ims;
    exports tu.varna.ims.controller;
    opens tu.varna.ims.controller to javafx.fxml;
}