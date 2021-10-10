package by.training.task05.beans;

import by.training.task05.services.calculation.Calculation;

/**
 * Tetrahedron wrapper used to store id
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FiguresRepository implements Repository {
    private int numberOfTetrahedron;
    private final List<TetrahedronWrapper> listFigures = new ArrayList<>();

    @Override
    public boolean add(Object figure) {
        TetrahedronWrapper tetrahedronWrapper = new TetrahedronWrapper((Tetrahedron) figure);
        numberOfTetrahedron++;
        return listFigures.add(tetrahedronWrapper);
    }

    @Override
    public void remove(int index) {
        listFigures.remove(index);
    }

    @Override
    public Tetrahedron get(int index) {
        return listFigures.get(index).tetrahedron;
    }

    @Override
    public boolean set(int index, Tetrahedron tetrahedron) {
        TetrahedronWrapper tetrahedronWrapper = new TetrahedronWrapper(tetrahedron);
        numberOfTetrahedron++;
        if (index>=0 && index <listFigures.size()){
            listFigures.set(index,tetrahedronWrapper);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public Map<Boolean,Tetrahedron> getById(int id) {
        Map<Boolean,Tetrahedron> result = new HashMap<>();
        for (TetrahedronWrapper tetrahedronWrapper : listFigures){
            if (tetrahedronWrapper.id == id){
                result.put(true, tetrahedronWrapper.tetrahedron);
                return result;
            }
        }
        result.put(false,null);
        return result;
    }

    @Override
    public Map<Boolean, Tetrahedron[]> getByName(String name) {
        Map<Boolean,Tetrahedron []> result = new HashMap<>();
        List <Tetrahedron> tetrahedronList = new ArrayList<>();
        for (TetrahedronWrapper tetrahedronWrapper : listFigures){
            if (tetrahedronWrapper.tetrahedron.getName().equals(name)){
                tetrahedronList.add(tetrahedronWrapper.tetrahedron);
            }
        }
        if (!tetrahedronList.isEmpty()){
             result.put(true,tetrahedronList.toArray(new Tetrahedron [0]));
        } else {
            result.put(false,null);
        }
        return result;
    }

    @Override
    public Map<Boolean, Tetrahedron[]> getPlaneXY(String name) {
        Map<Boolean,Tetrahedron []> result = new HashMap<>();
        List <Tetrahedron> tetrahedronList = new ArrayList<>();
        Calculation calculation = new Calculation();
        for (TetrahedronWrapper tetrahedronWrapper : listFigures){
            calculation.setTetrahedron(tetrahedronWrapper.tetrahedron);
            if (calculation.isPlaneXY()){
                tetrahedronList.add(tetrahedronWrapper.tetrahedron);
            }
        }
        if (!tetrahedronList.isEmpty()){
            result.put(true,tetrahedronList.toArray(new Tetrahedron [0]));
        } else {
            result.put(false,null);
        }
        return result;
    }

    @Override
    public Map<Boolean, Tetrahedron[]> getPlaneXZ(String name) {
        Map<Boolean,Tetrahedron []> result = new HashMap<>();
        List <Tetrahedron> tetrahedronList = new ArrayList<>();
        Calculation calculation = new Calculation();
        for (TetrahedronWrapper tetrahedronWrapper : listFigures){
            calculation.setTetrahedron(tetrahedronWrapper.tetrahedron);
            if (calculation.isPlaneXZ()){
                tetrahedronList.add(tetrahedronWrapper.tetrahedron);
            }
        }
        if (!tetrahedronList.isEmpty()){
            result.put(true,tetrahedronList.toArray(new Tetrahedron [0]));
        } else {
            result.put(false,null);
        }
        return result;
    }

    @Override
    public Map<Boolean, Tetrahedron[]> getPlaneYZ(String name) {
        Map<Boolean,Tetrahedron []> result = new HashMap<>();
        List <Tetrahedron> tetrahedronList = new ArrayList<>();
        Calculation calculation = new Calculation();
        for (TetrahedronWrapper tetrahedronWrapper : listFigures){
            calculation.setTetrahedron(tetrahedronWrapper.tetrahedron);
            if (calculation.isPlaneYZ()){
                tetrahedronList.add(tetrahedronWrapper.tetrahedron);
            }
        }
        if (!tetrahedronList.isEmpty()){
            result.put(true,tetrahedronList.toArray(new Tetrahedron [0]));
        } else {
            result.put(false,null);
        }
        return result;
    }

    @Override
    public Tetrahedron[] toArray() {
        Tetrahedron [] tetrahedronArr = new Tetrahedron[listFigures.size()];
        for (int i = 0; i < listFigures.size(); i++){
            tetrahedronArr[i] = listFigures.get(i).tetrahedron;
        }
        return tetrahedronArr;
    }

    private class TetrahedronWrapper {
        private final int id;
        private final Tetrahedron tetrahedron;

        public TetrahedronWrapper (Tetrahedron tetrahedron){
            this.id = numberOfTetrahedron;
            this.tetrahedron = tetrahedron;
        }

    }

}
