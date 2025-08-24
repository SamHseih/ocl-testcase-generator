:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

dynamicFixedsizeArrays_TwoDimVarArray_TwoDimVarArray_DC_Path_1(Self,InputArray):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_data,Self_dimensionSizes],Self_dimensionSizes = [Self_dim1, Self_dim2],
InputArray_dimensionSizes = [InputArray_dim1, InputArray_dim2],
decl_Array(Self_data,Self_dimensionSizes),
decl_Array(InputArray,InputArray_dimensionSizes),


[]#::(-32768)..32767,
%CLG Path Constrints,
nth1(2,Self_dimensionSizes,Var_1336735375),
nth1(1,Self_dimensionSizes,Var_1754894440),
((Var_1754894440 #> 0) , (Var_1336735375 #> 0)),
(Self_data = InputArray),

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(InputArray_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([InputArray]).
