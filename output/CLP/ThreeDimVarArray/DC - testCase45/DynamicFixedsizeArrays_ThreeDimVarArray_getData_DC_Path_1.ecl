:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

dynamicFixedsizeArrays_ThreeDimVarArray_getData_DC_Path_1(Self,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_data,Self_dimensionSizes],Self_dimensionSizes = [Self_dim1, Self_dim2, Self_dim3],

decl_Array(Self_data,Self_dimensionSizes),


%CLG Path Constrints,
nth1(3,Self_dimensionSizes,Var_482082765),
nth1(2,Self_dimensionSizes,Var_1754894440),
nth1(1,Self_dimensionSizes,Var_1998767043),
(((Var_1998767043 #> 0) , (Var_1754894440 #> 0)) , (Var_482082765 #> 0)),
(Result = Self_data),

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data]).
