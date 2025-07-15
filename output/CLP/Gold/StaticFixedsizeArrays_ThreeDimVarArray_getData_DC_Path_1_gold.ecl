:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(random).

solving_Path_1(Self,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_data,Self_dimensionSizes],Self_dimensionSizes = [Self_dim1, Self_dim2, Self_dim3],

decl_Array(Self_data,Self_dimensionSizes),


%CLG Path Constrints,
nth1(3,Self_dimensionSizes,Var_24119573),
nth1(2,Self_dimensionSizes,Var_1354003114),
nth1(1,Self_dimensionSizes,Var_825658265),
(((Var_825658265 #> 0),
(Var_1354003114 #> 0)),
(Var_24119573 #> 0)),
(Result = Self_data),

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data]).
