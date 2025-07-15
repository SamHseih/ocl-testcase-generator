:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(random).

staticFixedsizeVarArrays_VarArray_VarArray_DC_Path_1(Self,InputArray):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_data,Self_dimensionSizes],Self_dimensionSizes = [Self_dim],
InputArray_dimensionSizes = [InputArray_dim],
decl_Array(Self_data,Self_dimensionSizes),
decl_Array(InputArray,InputArray_dimensionSizes),


%CLG Path Constrints,
nth1(1,Self_dimensionSizes,Var_667821226),
nth1(1,Self_dimensionSizes,Var_1998767043),
((Var_1998767043 #> 0),
(Var_667821226 #< 10)),
(Self_data = InputArray),

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(InputArray_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([InputArray]).
