package com.jadson.backend;

import express.Express;
import com.jadson.backend.models.dao.ProvisioningDatabase;

public class App {
    public static void main(String[] args) {
        Express app = new Express();
        app.bind(new Routes());

        app.listen(()->{
            ProvisioningDatabase.run();
            System.out.println("Server Up");
        }, 8000);
    }
}