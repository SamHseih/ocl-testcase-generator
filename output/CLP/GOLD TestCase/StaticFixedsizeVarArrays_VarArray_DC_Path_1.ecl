:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(random).

staticFixedsizeVarArrays_VarArray_DC_Path_1(Self):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_data,Self_dimensionSizes],Self_dimensionSizes = [Self_dim],
decl_Array(Self_data,Self_dimensionSizes),


%CLG Path Constrints,
nth1(1,Self_dimensionSizes,Var_667821226),
nth1(1,Self_dimensionSizes,Var_1998767043),
((Var_1998767043 #> 0),
(Var_667821226 #< 10)),

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data]).
