package by.training.task05.beans;

import java.util.Map;

public interface Repository {
    boolean add (Object figure);
    void remove (int index);
    Tetrahedron get (int index);
    boolean set (int index, Tetrahedron tetrahedron);
    Map<Boolean,Tetrahedron> getById (int id);
    Map<Boolean,Tetrahedron []> getByName (String name);
    Map<Boolean,Tetrahedron []> getPlaneXY (String name);
    Map<Boolean,Tetrahedron []> getPlaneXZ (String name);
    Map<Boolean,Tetrahedron []> getPlaneYZ (String name);
    Tetrahedron [] toArray ();

}
