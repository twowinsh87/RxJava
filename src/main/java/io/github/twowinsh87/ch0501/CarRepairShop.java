package io.github.twowinsh87.ch0501;

import io.github.twowinsh87.utils.LogType;
import io.github.twowinsh87.utils.Logger;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class CarRepairShop {
    public int getCarRepairCostSync(int brokens) {
        return calculateCarRepair(brokens);
    }

    public Future<Integer> getCarRepairCostAsync(int brokens) {
        return CompletableFuture.supplyAsync(() -> calculateCarRepair(brokens));
    }

    private int calculateCarRepair(int brokens){
        Logger.log(LogType.PRINT, "# 차량 수리비 계산 중................");
        delay();
        return brokens * 20000;
    }

    private void delay(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
