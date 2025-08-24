:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

dynamicFixedsizeArrays_ThreeDimVarArray_DCC_Path_1_BDPath_1(Self):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_data,Self_dimensionSizes],Self_dimensionSizes = [Self_dim1, Self_dim2, Self_dim3],
decl_Array(Self_data,Self_dimensionSizes),


%CLG Path Constrints,
nth1(1,Self_dimensionSizes,Var_482082765),
(Var_482082765 #> 0),
nth1(2,Self_dimensionSizes,Var_1754894440),
(Var_1754894440 #> 0),
nth1(3,Self_dimensionSizes,Var_1998767043),
(Var_1998767043 #> 0),

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data]).
