:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(random).

solving_Path_1(Self,InputArray):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.

Self=[Self_data,Self_dimensionSizes],Self_dimensionSizes = [Self_dim],
InputArray_dimensionSizes = [InputArray_dim],

decl_Array(Self_data,Self_dimensionSizes),
decl_Array(InputArray,InputArray_dimensionSizes),

%CLG Path Constrints,
nth1(1,Self_dimensionSizes,Var_6320204),
nth1(1,Self_dimensionSizes,Var_932285561),
((Var_932285561 #> 0),
(Var_6320204 #< 10)),
(Self_data = InputArray),

%DimensionSizes Labeling Parts
labeling_Dim(InputArray_dimensionSizes),
labeling_Dim(Self_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data	,InputArray]).
