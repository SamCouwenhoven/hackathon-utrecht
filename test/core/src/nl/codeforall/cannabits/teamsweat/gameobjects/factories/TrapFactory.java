package nl.codeforall.cannabits.teamsweat.gameobjects.factories;

import nl.codeforall.cannabits.teamsweat.gameobjects.traps.FreezeTrap;
import nl.codeforall.cannabits.teamsweat.gameobjects.traps.Trap;

public abstract class TrapFactory {
    public Trap getTrap(TrapType trapType) {
        switch (trapType) {
            case FREEZE_TRAP:
                return new FreezeTrap();

        }
        return new FreezeTrap();
    }
}
