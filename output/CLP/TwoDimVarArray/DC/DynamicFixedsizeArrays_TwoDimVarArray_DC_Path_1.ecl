:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

dynamicFixedsizeArrays_TwoDimVarArray_DC_Path_1(Self):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_data,Self_dimensionSizes],Self_dimensionSizes = [Self_dim1, Self_dim2],
decl_Array(Self_data,Self_dimensionSizes),


[]#::(-32768)..32767,
%CLG Path Constrints,
nth1(2,Self_dimensionSizes,Var_1353070773),
nth1(1,Self_dimensionSizes,Var_1107024580),
((Var_1107024580 #> 0) , (Var_1353070773 #> 0)),

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data]).
